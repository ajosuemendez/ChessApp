
export default function Piece({pieceType, theme, framePosition}) {
    
    if ( pieceType === null ) {
        return;
    }

    const imageSource = process.env.PUBLIC_URL + `/images/themes/${theme}/${pieceType}-${theme}.png`;

    return <image   href={imageSource}
                    alt={`Piece ${pieceType}`} 
                    width={40}
                    height={40}
                    x = {framePosition.x}
                    y = {framePosition.y}
                    style={{ pointerEvents: 'none' }}/>
}