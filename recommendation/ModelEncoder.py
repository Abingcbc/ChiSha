import pandas as pd
from deepctr.inputs import SparseFeat, VarLenSparseFeat, DenseFeat, get_feature_names
from urllib.request import urlopen
from sklearn.preprocessing import LabelEncoder, MinMaxScaler
from tensorflow.python.keras.preprocessing.sequence import pad_sequences


def split(column: pd.Series, key2index: map):
	column.apply(lambda x: x.split())


class ModelEncoder:
	var_sparse_dict = {
		'taste': [-1, -1, 20, 'taste'],
		'style': [-1, -1, 20, 'style'],
		'hist_recipe': [-1, -1, 20, 'recipe'],
		'recipe_taste': [-1, -1, 20, 'recipe_taste'],
		'recipe_style': [-1, -1, 20, 'recipe_recipe_style'],
		'ingredient': [-1, -1, 20, 'recipe_ingredient'],
		'seasoning': [-1, -1, 20, 'recipe_recipe_seasoning']
	}
	
	fixed_sparse_dict = {
		'gender': [2, 20],
		'age': [5 + 1, 20],
		'born_place': [34 + 1, 20],
		'recipe': [-1, 20]
	}
	# attributes that share common semantics should share common mapping rules
	mapping_share_dict = {
		'taste': 'taste',
		'style': 'style',
		'recipe_taste': 'taste',
		'recipe_style': 'recipe_style',
		'ingredient': 'ingredient',
		'seasoning': 'seasoning',
		'gender': 'gender',
		'age': 'age',
		'born_place': 'born_place',
		'hist_recipe': 'recipe',
		'recipe': 'recipe'
	}
	behavior_list = ['recipe']
	
	def __init__(self):
		self.dicts_key2index = {}
		for key in self.var_sparse_dict:
			self.dicts_key2index[self.mapping_share_dict[key]] = {'-1': 1}
		for key in self.fixed_sparse_dict:
			self.dicts_key2index[self.mapping_share_dict[key]] = {'-1': 1}
		self._train = True
	
	def encode(self, data: pd.DataFrame):
		# encode fixed length sparse features
		for feat in data.columns:
			if feat in self.fixed_sparse_dict:
				value = self.fixed_sparse_dict[feat]
				data[feat] = data[feat].fillna('-1')
				data[feat] = data[feat].astype(str)
				data[feat] = self._key_index_mapping(data[feat])
				if self._train:
					if value[0] < len(self.getMappingDict(feat)):
						self.fixed_sparse_dict[feat][0] = len(self.getMappingDict(feat))
			elif feat in self.var_sparse_dict:
				value = self.var_sparse_dict[feat]
				data[feat] = data[feat].fillna('-1')
				data[feat] = data[feat].astype(str)
				data[feat] = data[feat].apply(lambda x: x.split('|'))
				data[feat] = self._key_index_mapping(data[feat])
				max_len = max(list(map(len, data[feat])))
				data[feat].apply(lambda x: x + (max_len-len(x)*[0]))
				if self._train:
					if value[0] < max_len:
						self.var_sparse_dict[feat][0] = max_len
					if value[1] < len(self.getMappingDict(feat)) + 1:
						# +1 for '0' padding
						self.var_sparse_dict[feat][1] = len(self.getMappingDict(feat)) + 1
		return data
	
	def _key_index_mapping(self, col: pd.Series):
		name = col.name
		dict_name = self.mapping_share_dict[name]
		if self._train:
			# if we do not explicitly define key2index['-1'] = 1
			# we have trouble when NA is absent when training and existent when evaluating
			def func(element):
				if isinstance(element, list):
					for i in range(len(element)):
						if element[i] not in self.dicts_key2index[dict_name]:
							self.dicts_key2index[dict_name][element[i]] = len(self.dicts_key2index[dict_name]) + 1
						element[i] = self.dicts_key2index[dict_name][element[i]]
				else:
					if element not in self.dicts_key2index[dict_name]:
						self.dicts_key2index[dict_name][element] = len(self.dicts_key2index[dict_name]) + 1
					element = self.dicts_key2index[dict_name][element]
				return element
		else:
			def func(element):
				if element.isinstance(list):
					for i in len(element):
						if element[i] not in self.dicts_key2index[dict_name]:
							element[i] = '-1'
						element[i] = self.dicts_key2index[dict_name].get(element[i])
				else:
					if element not in self.dicts_key2index[dict_name]:
						element = '-1'
					element = self.dicts_key2index[dict_name].get(element)
				return element
		return col.apply(func)
	
	def getFeatureColumns(self):
		feature_columns = []
		for feat, value in self.fixed_sparse_dict.items():
			feature_columns.append(SparseFeat(feat, vocabulary_size=value[0], embedding_dim=value[1]))
		for feat, value in self.var_sparse_dict.items():
			feature_columns.append(
				VarLenSparseFeat(feat, maxlen=value[0], vocabulary_size=value[1], embedding_dim=value[2],
				                 embedding_name=value[3]))
		return feature_columns
	
	def train(self):
		self._train = True
	
	def eva(self):
		self._train = False
		
	def getMappingDict(self, attribute:str):
		return self.dicts_key2index[self.mapping_share_dict[attribute]]
