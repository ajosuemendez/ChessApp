import '../styles/HistoryTable.css';
import Button from '../layout/Button';

// Static data
const undoImage = process.env.PUBLIC_URL + `/images/game/undo.png`;
const redoImage = process.env.PUBLIC_URL + `/images/game/redo.png`;


export default function HistoryTable({ moves, onUndo, onRedo }) {
  const players = ['TheChessNut1', 'TheChessNut2', 'TheChessNut3'];

  const undoCallBack = () => {
    console.log("Making API Call for Undoing Move");
    onUndo();
  };

  const redoCallBack = () => {
    console.log("Making API Call for Redoing Move");
    onRedo();
  };


  return (
    <div className='wrapper-container'>
    <div className='history-container'>
        <h2>Move History</h2>
            <span className="history-player-label">{players[0]}</span>
            <span className="history-player-label">{players[1]}</span>
            <span className="history-player-label">{players[2]}</span>
        <div className="chess-history">
            <div className="move-table">
                <div className="player-column">
                    {moves.map((move, index) => index % 3 === 0 && <p key={index}>{move}</p>)}
                </div>
                <div className="player-column">
                    {moves.map((move, index) => index % 3 === 1 && <p key={index}>{move}</p>)}
                </div>
                <div className="player-column">
                    {moves.map((move, index) => index % 3 === 2 && <p key={index}>{move}</p>)}
                </div>
            </div>
        </div>
        <Button text={"Undo"} imageSrc={undoImage} clickHandler={undoCallBack}/>
        <Button text={"Redo"} imageSrc={redoImage} clickHandler={redoCallBack}/>
    </div>
    </div>
  );
};
