import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import axios from 'axios'
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css'


const app=createApp(App);

axios.defaults.withCredentials=true;
axios.defaults.baseURL = '/api';
app.config.globalProperties.$http = axios;
//Vue3.0中不支持Vue.prototype的方式来挂载axios了，改用上面的方法挂载

app.use(store).use(ElementPlus);
app.use(router);
app.mount('#app');
