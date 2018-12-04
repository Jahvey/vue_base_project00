import axios from 'axios'

let base = ''

export const getContractList = params => { return axios.get(`${base}/contract/list`, { params: params }) }
