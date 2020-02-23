import axios from 'axios';

class getMenuService {
     getTodayMenu(date) {
        return axios.get('http://localhost:8080/menu/todaymenu');
    }
}

export default new getMenuService();