import React, {useState} from 'react'
import { Link } from 'react-router-dom';
import Navbar from './../components/Navbar';

export default function RegisterScreen() {
    
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');

    // register action
    const submitRegisterHandler = (e) => {
        e.preventDefault();
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
                                <span>Register</span>
                                <hr id ="Indicator"></hr>
                            </div>

                            <form onSubmit={submitRegisterHandler}>
                                <input type="text" id="username" placeholder="Username" required onChange={(e) => setUsername(e.target.value)}></input>
                                <input type="email" id="email" placeholder="Enter Email" required onChange={(e) => setEmail(e.target.value)}></input>
                                <input type="password" id="password" placeholder="Enter Password"required onChange={(e) => setPassword(e.target.value)}></input>
                                <button type="submit" className="btn">Register</button>
                                <a href="">Forgot Password</a>
                                <br/>
                                <p> Have account ? <Link to="/login">Login</Link> </p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
