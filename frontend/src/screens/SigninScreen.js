import React, {useState} from 'react'
import { Link } from 'react-router-dom';
import Navbar from './../components/Navbar';
import { useDispatch } from 'react-redux';
import { signin } from './../actions/UserAction';

export default function SigninScreen() {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const dispatch = useDispatch();

    // singin action
    const submitSigninHandler = (e) => {
        e.preventDefault();
        dispatch(signin(email, password));
    }

    return (
        <div className="account-page">
            <div className="container">
                <Navbar></Navbar>
                <div className="row">
                    <div className="col-2">
                        <img src="../images/image1.png" alt="img demo"></img>
                    </div>
                    <div className="col-2">
                        <div className="form-container">
                            <div className="form-btn">
                                <span>Login</span>
                                <hr id ="Indicator"></hr>
                            </div>

                            <form onSubmit={submitSigninHandler}>
                                <input type="email" id="email" placeholder="Enter Email" required onChange={(e) => setEmail(e.target.value)}></input>
                                <input type="password" id="password" placeholder="Enter Password"required onChange={(e) => setPassword(e.target.value)}></input>
                                <button type="submit" className="btn">Login</button>
                                <a href="">Forgot Password</a>
                                <br/>
                                <p> New Customer ? <Link to="/register">Create Your Account</Link> </p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
