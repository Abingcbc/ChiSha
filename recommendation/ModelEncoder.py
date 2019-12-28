import pandas as pd
from urllib.request import urlopen
from sklearn.preprocessing import LabelEncoder, MinMaxScaler
from tensorflow.python.keras.preprocessing.sequence import pad_sequences
def split(column: pd.Series, key2index: map):
	column.apply(lambda x: x.split())
	
	
class ModelEncoder:
	var_sparse_dict = {
		'preference': [-1, -1, 20, 'preference'],
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
	behavior_list = ['recipe']
	
	def __init__(self):
		self.dict_key2index={}
		for key in self.var_sparse_dict.keys:
			self.dict_key2index[key] = {'-1': '1'}
		for key in self.fixed_sparse_dict:
			self.dict_key2index[key] = {'-1': '1'}
		self._train = True
		
	def encode(self, data: pd.DataFrame):
		#encode fixed length sparse features
		for feat, value in self.fixed_sparse_dict.items():
			data[feat] = data[feat].astype(str)
			data[feat] = data[feat].fillna('-1')
			self._key_index_mapping(data[feat])
			if self._train:
				if value[0] == -1:
					self.fixed_sparse_dict[feat][0] = len(self.dict_key2index[feat])
		for feat, value in self.var_sparse_dict.items():
			data[feat] = data[feat].astype(str)
			data[feat] = data[feat].fillna('-1')
			self._key_index_mapping(data[feat])
			max_len = max(list(map(len,data[feat])))
			data[feat] = pad_sequences(data[feat], maxlen=max_len, padding='post')
			if self._train:
				if value[0] == -1:
					self.var_sparse_dict[feat][0] = max_len
				if value[1] == -1:
					self.var_sparse_dict[feat][1] = len(self.dict_key2index[feat]) + 1
	def _key_index_mapping(self, col: pd.Series):
		name = col.name
		if self._train:
			#if we do not explicitly define key2index['-1'] = 1
			#we have trouble when NA is absent when training and existent when evaluating
			def func(element):
				if element.isinstance(list):
					for i in len(element):
						if element[i] not in self.dict_key2index[name]:
							self.dict_key2index[name][element[i]] = len(self.dict_key2index[name]) + 1
						element[i] = self.dict_key2index[name][element[i]]
				else:
					if element not in self.dict_key2index[name]:
						self.dict_key2index[name][element] = len(self.dict_key2index[name]) + 1
					element = self.dict_key2index[name][element]
				return element
		else:
			def func(element):
				if element.isinstance(list):
					for i in len(element):
						if element[i] not in self.dict_key2index[name]:
							element[i] = '-1'
						element[i] = self.dict_key2index[name].get(element[i])
				else:
					if element not in self.dict_key2index[name]:
						element = '-1'
					element = self.dict_key2index[name].get(element)
				return element
		col.apply(func)
		
	def train(self):
		self._train = True
		
	def eva(self):
		self._train = False