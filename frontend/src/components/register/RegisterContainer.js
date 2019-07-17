import {connect} from "react-redux";
import Register from "./Register";
import addUserRegisterData from "../../actions/addUserRegisterData";

const mapStateToProps = (state) => ({
    data: state.auth.register
});

const mapActionsToProps = (dispatch) => ({
    addUserRegisterData: async payload => dispatch(addUserRegisterData(payload))
});


export default connect(mapStateToProps, mapActionsToProps)(Register);