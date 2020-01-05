import numpy as np
from urllib.request import urlopen
import pandas as pd
from ModelEncoder import ModelEncoder
from deepctr.models import DIN, DeepFM
from tensorflow.keras.models import save_model
from deepctr.inputs import SparseFeat, VarLenSparseFeat, DenseFeat, get_feature_names
from sklearn.preprocessing import LabelEncoder, MinMaxScaler
from tensorflow.python.keras.preprocessing.sequence import pad_sequences
import pickle
import copy


class Trainer:
	def __init__(self):
		self.data = None
		self.encoder = None
		self.model = None
		# number of positive samples
		self.num_pos = None
		self.recipeDomain = None
		
	def loadData(self, url: str):
		self.data = pd.read_csv(url)
		self.recipeDomain = pd.read_csv(url)
		self.num_pos = self.data.shape[0]
		self.encoder = ModelEncoder()
		self.encoder.train()
	
	def preProcessData(self):
		self.data = self.encoder.encode(self.data)
		self.data['result'] = [1] * self.num_pos
		
		self.recipeDomain = self.encoder.encode(self.recipeDomain)

		self.build_negative_data()
		
	def buildModel(self):
		feature_columns = self.encoder.getFeatureColumns()
		self.model = DIN(feature_columns, self.encoder.behavior_list)
		self.model.compile('adam', 'binary_crossentropy', metrics=['binary_crossentropy'])
	
	def train(self):
		model_input = {}
		for feat, _ in self.encoder.fixed_sparse_dict + self.encoder.var_sparse_dict:
			model_input[feat] = self.data[feat]
		history = self.model.fit(model_input, self.data['gt'].values, batch_size=256, epochs=10, verbose=2, validation_split=0.2, shuffle = True)
		
	def dump_model(self, path: str):
		save_model(self.model, path)
	
	def dump_encoder(self, path: str):
		pickle.dump(self.encoder, self, protocol=4)
	
	def update(self):
		url = ''
		self.recipeDomain = pd.read_csv(url)
		self.encoder.encode(self.recipeDomain)

	def build_negative_data(self):
		for i in range(self.num_pos):
			record = self.data.iloc[i]
			clicked_set = record['hist_recipe'] + record['recipe'][i]
			for j in self.recipeDomain.shape[0]:
				if self.recipeDomain.iloc[j]['recipe'] not in clicked_set:
					# valid unclicked combination
					for feat in record.columns:
						if feat in self.recipeDomain.columns:
							record[feat] = self.recipeDomain.iloc[j][feat]
					record['result'] = 0
					self.data.append(record)
