import '../styles/HistoryTable.css';

export default function HistoryTable({ moves }) {
  const players = ['TheChessNut1', 'TheChessNut2', 'TheChessNut3'];

  return (
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
    </div>
  );
};
