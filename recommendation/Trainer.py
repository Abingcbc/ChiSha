import numpy as np
from urllib.request import urlopen
import pandas as pd
from ModelEncoder import ModelEncoder
from deepctr.models import DIN, DeepFM
from deepctr.inputs import SparseFeat, VarLenSparseFeat, DenseFeat, get_feature_names
from sklearn.preprocessing import LabelEncoder, MinMaxScaler
from tensorflow.python.keras.preprocessing.sequence import pad_sequences
import pickle

class Trainer:
	def __init__(self):
		self.data = None
		self.encoder = None
		self.model = None
		
	def loadData(self, data_source: str):
		self.data = pd.read_csv(data_source)
		self.encoder = ModelEncoder()
		self.encoder.train()
	
	def preProcessData(self):
		self.encoder.encode(self.data)
		
	def buildModel(self):
		feature_columns = []
		for feat, value in self.encoder.fixed_sparse_dict:
			feature_columns.append(SparseFeat(feat, vocabulary_size=value[0], embedding_dim=value[1]))
		for feat, value in self.encoder.var_sparse_dict:
			feature_columns.append(VarLenSparseFeat(feat, maxlen=value[0], vocabulary_size=value[1], embedding_dim=value[2], embedding_name=value[3]))
		
		self.model = DIN(feature_columns, self.model.behavior_feature_list)
		self.model.compile('adam', 'binary_crossentropy', metrics=['binary_crossentropy'])
		
	def train(self):
		model_input = {}
		for feat, _ in self.encoder.fixed_sparse_dict + self.encoder.var_sparse_dict:
			model_input[feat] = self.data[feat]
	def dump_model(self, path: str):
		self.model.save_weights(path)
	
	def dump_encoder(self, path: str):
		pickle.dump(self.encoder, self, protocol=4)
		
	
