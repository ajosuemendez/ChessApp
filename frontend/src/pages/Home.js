import "../styles/Home.css";
import { Link } from 'react-router-dom';

const chessboardImage = process.env.PUBLIC_URL + `/images/home/chessboardSS.png`;


export default function Home() {
    return(
        <section>
            <div className="home-container">
                <h1 className="call-action-title">Play with your Friends and Familiy in a 3 Player Chess!</h1>
                <Link className="btn-call-action" to="/game"> Play Now!</Link>
                <img src={chessboardImage} className="chessboard-home-img"/>
            </div>
        </section>

    );
}