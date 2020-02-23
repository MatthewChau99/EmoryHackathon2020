import React, {Component} from 'react';
import {Route, Switch} from 'react-router-dom';
import {connect} from 'react-redux';
import MenuContainer from "./MenuContainer";
import MainPageContainer from "./MainPageContainer";

class Routes extends Component {
    render() {
        return (
            <div>
                <Switch>
                    <Route path='/Menu' exact={true} component={MenuContainer}/>
                    <Route path='' exact={true} component={MainPageContainer}/>
                </Switch>
            </div>
        );
    }
}

export default Routes;