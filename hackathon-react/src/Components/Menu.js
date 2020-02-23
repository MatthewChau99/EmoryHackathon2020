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
            <div className="container">
                <div className='float-md-none'>
                    <h3 align='center'>Rate Today's Menu</h3>
                </div>
            </div>
        );
    }
}

export default Menu;