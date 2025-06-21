import axios from 'axios';

const EMPLOYEE_SERVICE_BASEURL="http://localhost:9191/employee-service/api/employees";

const EMPLOYEE_ID =10;

class EmployeeService {
    getEmployee(){
       return axios.get(EMPLOYEE_SERVICE_BASEURL+'/'+EMPLOYEE_ID);
    }
}

export default new EmployeeService;