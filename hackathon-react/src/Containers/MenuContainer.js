import React, {Component} from 'react';
import ratingImg from "../Assets/img/rate.png";

class MenuContainer extends Component {
    render() {
        return (
            <div>
                <div className="container2">
                    <span>
                        Today's Menu
                    </span>
                </div>
                <img src={ratingImg} alt='RATE YOUR FOOD!' width='1500' height='800'/>
            </div>
        );
    }
}

export default MenuContainer;