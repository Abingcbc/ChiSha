import numpy as np
from urllib.request import urlopen
import pandas as pd
from tensorflow.keras.models import load_model
from deepctr.layers import custom_objects
from deepctr.models import DIN,DeepFM
from ModelEncoder import ModelEncoder
from deepctr.inputs import SparseFeat,VarLenSparseFeat,DenseFeat,get_feature_names
from sklearn.preprocessing import LabelEncoder, MinMaxScaler
from tensorflow.python.keras.preprocessing.sequence import pad_sequences
from ModelEncoder import ModelEncoder
import pickle

class Evaluator:
	def __init__(self):
		self.encoder = None
		self.model = None
		self.recipeDomain = None
	
	def load_encoder(self, path :str):
		self.encoder = pickle.load(path)
		self.encoder.eva()
		
	def load_model(self, path: str):
		feature_columns = self.encoder.getFeatureColumns()
		self.model = load_model(path, custom_objects)
	
	def update(self):
		url = ''
		self.recipeDomain = pd.read_csv(url)
		self.encoder.encode(self.recipeDomain)
		
	def evaluate(self, user_domain: dict):
		pd_user_domain = pd.DataFrame(user_domain, copy=True)
		cartesian = pd.merge(pd_user_domain, self.recipeDomain, how='outer')
		model_input = {name: cartesian[name].values for name, _ in self.encoder.fixed_sparse_dict + self.encoder.var_sparse_dict}
		pred_ans = self.model.predict(model_input, model_input)
		return pred_ans