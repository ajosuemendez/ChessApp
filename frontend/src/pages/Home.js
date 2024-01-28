import { useNavigate } from 'react-router-dom';
import "../styles/Home.css";

const chessboardImage = process.env.PUBLIC_URL + `/images/home/chessboardSS.png`;

export default function Home() {
    const navigate = useNavigate();

    const startNewGame = async () => {
        try {
            // Make your API call here
            const response = await fetch('http://localhost:8080/creategame');
            const data = await response.json();

            console.log("retrieve data create game:", data);
            // Redirect to the "/game" route with the new data
            navigate('/game', { state: { gameData: data } });
        } catch (error) {
            console.error('Error fetching game data:', error);
        }
    };

    return (
        <section>
            <div className="home-container">
                <h1 className="call-action-title">Play with your Friends and Family in a 3 Player Chess!</h1>
                <button className="btn-call-action" onClick={startNewGame}>Start New Game Now!</button>
                <img src={chessboardImage} alt="Chessboard" className="chessboard-home-img" />
            </div>
        </section>
    );
}
