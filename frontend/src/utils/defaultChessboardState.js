const defaultChessboardState = [
  // Left Quadrant White 
  {id:"H12", piece: "white-rook",   isValid: false},
  {id:"H11", piece: "white-pawn",   isValid: false}, 
  {id:"H10", piece: "",             isValid: false},
  {id:"H9",  piece: "",             isValid: true },

  {id:"G12", piece: "white-knight", isValid: false}, 
  {id:"G11", piece: "white-pawn",   isValid: false},  
  {id:"G10", piece: "",             isValid: false},
  {id:"G9",  piece: "",             isValid: false}, 

  {id:"F12", piece: "white-bishop", isValid: false},  
  {id:"F11", piece: "white-pawn",   isValid: false},
  {id:"F10", piece: "",             isValid: false}, 
  {id:"F9",  piece: "",             isValid: false}, 

  {id:"E12", piece: "white-queen",  isValid: false}, 
  {id:"E11", piece: "white-pawn",   isValid: false},
  {id:"E10", piece: "",             isValid: false},
  {id:"E9",  piece: "",             isValid: false},

  
  // Right Quadrant White 
  {id:"I12", piece: "white-king",   isValid: false},
  {id:"I11", piece: "white-pawn",   isValid: false}, 
  {id:"I10", piece: "",             isValid: false},
  {id:"I9",  piece: "",             isValid: false},

  {id:"J12", piece: "white-bishop", isValid: false}, 
  {id:"J11", piece: "white-pawn",   isValid: false},
  {id:"J10", piece: "",             isValid: false}, 
  {id:"J9",  piece: "",             isValid: false},

  {id:"K12", piece: "white-knight", isValid: false}, 
  {id:"K11", piece: "white-pawn",   isValid: false},  
  {id:"K10", piece: "",             isValid: false},
  {id:"K9",  piece: "",             isValid: false}, 

  {id:"L12", piece: "white-rook",   isValid: false}, 
  {id:"L11", piece: "white-pawn",   isValid: false},  
  {id:"L10", piece: "",             isValid: false},  
  {id:"L9",  piece: "",             isValid: false},  
  

  // Left Quadrant Black
  {id:"L8", piece: "black-rook",    isValid: false}, 
  {id:"L7", piece: "black-pawn",    isValid: false},
  {id:"L6", piece: "",              isValid: false}, 
  {id:"L5", piece: "",              isValid: false},

  {id:"K8", piece: "black-knight",  isValid: false},
  {id:"K7", piece: "black-pawn",    isValid: false}, 
  {id:"K6", piece: "",              isValid: false}, 
  {id:"K5", piece: "",              isValid: false}, 

  {id:"J8", piece: "black-bishop",  isValid: false},
  {id:"J7", piece: "black-pawn",    isValid: false},
  {id:"J6", piece: "",              isValid: false}, 
  {id:"J5", piece: "",              isValid: false},

  {id:"I8",  piece: "black-queen",  isValid: false},
  {id:"I7",  piece: "black-pawn",   isValid: false},
  {id:"I6",  piece: "",             isValid: false},
  {id:"I5",  piece: "",             isValid: false},


  // Right Quadrant Black
  {id:"D8", piece: "black-king",    isValid: false},
  {id:"D7", piece: "black-pawn",    isValid: false},
  {id:"D6", piece: "",              isValid: false},
  {id:"D5", piece: "",              isValid: false}, 

  {id:"C8", piece: "black-bishop",  isValid: false}, 
  {id:"C7", piece: "black-pawn",    isValid: false}, 
  {id:"C6", piece: "",              isValid: false},
  {id:"C5", piece: "",              isValid: false}, 

  {id:"B8", piece: "black-knight",  isValid: false},
  {id:"B7", piece: "black-pawn",    isValid: false},
  {id:"B6", piece: "",              isValid: false}, 
  {id:"B5", piece: "",              isValid: false}, 

  {id:"A8", piece: "black-rook",    isValid: false},
  {id:"A7", piece: "black-pawn",    isValid: false}, 
  {id:"A6", piece: "",              isValid: false}, 
  {id:"A5", piece: "",              isValid: false},


  // Left Quadrant Red
  {id:"A4", piece: "",              isValid: false},
  {id:"A3", piece: "",              isValid: false}, 
  {id:"A2", piece: "yellow-pawn",   isValid: false},
  {id:"A1", piece: "yellow-rook",   isValid: false},

  {id:"B4", piece: "",              isValid: false},
  {id:"B3", piece: "",              isValid: false}, 
  {id:"B2", piece: "yellow-pawn",   isValid: false},
  {id:"B1", piece: "yellow-knight", isValid: false},

  {id:"C4", piece: "",              isValid: false},
  {id:"C3", piece: "",              isValid: false}, 
  {id:"C2", piece: "yellow-pawn",   isValid: false},
  {id:"C1", piece: "yellow-bishop", isValid: false},

  {id:"D4", piece: "",              isValid: false},
  {id:"D3", piece: "",              isValid: false}, 
  {id:"D2", piece: "yellow-pawn",   isValid: false},
  {id:"D1", piece: "yellow-queen",  isValid: false},


  //Right Quadrant Red
  {id:"E4", piece: "",              isValid: false},
  {id:"E3", piece: "",              isValid: false}, 
  {id:"E2", piece: "yellow-pawn",   isValid: false},
  {id:"E1", piece: "yellow-king",   isValid: false},

  {id:"F4", piece: "",              isValid: false}, 
  {id:"F3", piece: "",              isValid: false},
  {id:"F2", piece: "yellow-pawn",   isValid: false},
  {id:"F1", piece: "yellow-bishop", isValid: false},

  {id:"G4", piece: "",              isValid: false},
  {id:"G3", piece: "",              isValid: false},
  {id:"G2", piece: "yellow-pawn",   isValid: false},
  {id:"G1", piece: "yellow-knight", isValid: false},

  {id:"H4",  piece: "",             isValid: false},
  {id:"H3",  piece: "",             isValid: false},
  {id:"H2",  piece: "yellow-pawn",  isValid: false},
  {id:"H1",  piece: "yellow-rook",  isValid: false}

];

export default defaultChessboardState;

