import axios from "axios";



const api = {
    // urlPrefix:"http://localhost:9090/folk",
    urlPrefix:"http://47.93.77.117:9090/folk",
    getText: (id) => {
        return axios({
            url: api.urlPrefix+'/text',
            method: 'get',
            params: { "id": id }
        }).then((res) => {
            console.log(res)
            return Promise.resolve(res);
        }).catch((error) => {
            // 处理请求错误
            return Promise.reject(error);
        });
    },
    uploadText: (content,id) => {
        return axios({
            url: api.urlPrefix+'/text',
            method: 'post',
            data: { "content": content, "id": id },
            headers: { 'Content-Type': 'application/json' },
        }).then((res) => {
            return Promise.resolve(res);
        }).catch((error) => {
            // 处理请求错误
            return Promise.reject(error);
        });
    },
    uploadImg:(file)=>{
        const formData = new FormData();
        formData.append('image', file);
        return axios({
            url: api.urlPrefix+'/image',
            method: 'post',
            data: formData,
            headers: { 'Content-Type': 'multipart/form-data' },
        }).then((res) => {
            console.log(res)
            return Promise.resolve(res)
        })
    }
};
export default api
