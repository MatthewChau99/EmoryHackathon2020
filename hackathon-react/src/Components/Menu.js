import React, {Component} from 'react';
import getMenuService from "../Service/getMenuService";
import ratingImg from "../Assets/img/rate.png";

class Menu extends Component {
    date;
    constructor(props){
        super(props);
        this.setState = {
            menu: [],
            message: null
        };
        this.refreshMenu = this.refreshMenu.bind(this);
    }

    componentDidMount() {
        this.refreshMenu(this.date);
    }

    refreshMenu(date) {
        getMenuService.getTodayMenu(date).then(
            response => {
                console.log(response);
                this.setState({menu: response.data})
            }
        )
    }
    render() {
        return (
            <div className="container2">
                <div className = "center1">
                    <p>Rate Today's Menu</p>
                </div>
            </div>
        );
    }
}

export default Menu;