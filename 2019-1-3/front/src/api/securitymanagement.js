import {myGet,myPost} from '@/utils/request1'
import request from '@/utils/request'
export function getPersonCustomerList(queryParams) {

  return myPost('customer/natural/naturalPerson',queryParams);

}
