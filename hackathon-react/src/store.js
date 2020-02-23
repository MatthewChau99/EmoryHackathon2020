import { createStore, compose } from 'redux';
import rootReducer from './Reducers/errorsReducers.js';
// import { persistStore, persistCombineReducers } from 'redux-persist'

import { persistStore } from 'redux-persist';
// import storage from 'redux-persist/es/storage' // default: localStorage if web

import DevTools from './Containers/DevTools';

let store = compose(
  DevTools.instrument(),
)(createStore)(rootReducer);

persistStore(store);

export default store;
