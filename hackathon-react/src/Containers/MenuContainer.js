import React, {Component} from 'react';
import Menu from "../Components/Menu";
import ratingImg from "../Assets/img/rate.png";

class MenuContainer extends Component {
    render() {
        return (
            <div>
                <Menu/>
                <img src={ratingImg} alt='RATE YOUR FOOD!' width='1500' height='800'/>
            </div>
        );
    }
}

export default MenuContainer;