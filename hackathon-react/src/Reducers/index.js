import {combineReducers} from "redux";
import errorsReducer from './errorsReducers';

export default combineReducers({
    errors: errorsReducer
});