const defaultChessboardState = [
  // Left Quadrant White 
  {id:"h12", piece: "white-rook",   isValid: false},
  {id:"h11", piece: "white-pawn",   isValid: false}, 
  {id:"h10", piece: "",             isValid: false},
  {id:"h9",  piece: "",             isValid: true },

  {id:"g12", piece: "white-knight", isValid: false}, 
  {id:"g11", piece: "white-pawn",   isValid: false},  
  {id:"g10", piece: "",             isValid: false},
  {id:"g9",  piece: "",             isValid: false}, 

  {id:"f12", piece: "white-bishop", isValid: false},  
  {id:"f11", piece: "white-pawn",   isValid: false},
  {id:"f10", piece: "",             isValid: false}, 
  {id:"f9",  piece: "",             isValid: false}, 

  {id:"e12", piece: "white-queen",  isValid: false}, 
  {id:"e11", piece: "white-pawn",   isValid: false},
  {id:"e10", piece: "",             isValid: false},
  {id:"e9",  piece: "",             isValid: false},

  
  // Right Quadrant White 
  {id:"i12", piece: "white-king",   isValid: false},
  {id:"i11", piece: "white-pawn",   isValid: false}, 
  {id:"i10", piece: "",             isValid: false},
  {id:"i9",  piece: "",             isValid: false},

  {id:"j12", piece: "white-bishop", isValid: false}, 
  {id:"j11", piece: "white-pawn",   isValid: false},
  {id:"j10", piece: "",             isValid: false}, 
  {id:"j9",  piece: "",             isValid: false},

  {id:"k12", piece: "white-knight", isValid: false}, 
  {id:"k11", piece: "white-pawn",   isValid: false},  
  {id:"k10", piece: "",             isValid: false},
  {id:"k9",  piece: "",             isValid: false}, 

  {id:"l12", piece: "white-rook",   isValid: false}, 
  {id:"l11", piece: "white-pawn",   isValid: false},  
  {id:"l10", piece: "",             isValid: false},  
  {id:"l9",  piece: "",             isValid: false},  
  

  // Left Quadrant Black
  {id:"l8", piece: "black-rook",    isValid: false}, 
  {id:"l7", piece: "black-pawn",    isValid: false},
  {id:"l6", piece: "",              isValid: false}, 
  {id:"l5", piece: "",              isValid: false},

  {id:"k8", piece: "black-knight",  isValid: false},
  {id:"k7", piece: "black-pawn",    isValid: false}, 
  {id:"k6", piece: "",              isValid: false}, 
  {id:"k5", piece: "",              isValid: false}, 

  {id:"j8", piece: "black-bishop",  isValid: false},
  {id:"j7", piece: "black-pawn",    isValid: false},
  {id:"j6", piece: "",              isValid: false}, 
  {id:"j5", piece: "",              isValid: false},

  {id:"i8",  piece: "black-queen",  isValid: false},
  {id:"i7",  piece: "black-pawn",   isValid: false},
  {id:"i6",  piece: "",             isValid: false},
  {id:"i5",  piece: "",             isValid: false},


  // Right Quadrant Black
  {id:"d8", piece: "black-king",    isValid: false},
  {id:"d7", piece: "black-pawn",    isValid: false},
  {id:"d6", piece: "",              isValid: false},
  {id:"d5", piece: "",              isValid: false}, 

  {id:"c8", piece: "black-bishop",  isValid: false}, 
  {id:"c7", piece: "black-pawn",    isValid: false}, 
  {id:"c6", piece: "",              isValid: false},
  {id:"c5", piece: "",              isValid: false}, 

  {id:"b8", piece: "black-knight",  isValid: false},
  {id:"b7", piece: "black-pawn",    isValid: false},
  {id:"b6", piece: "",              isValid: false}, 
  {id:"b5", piece: "",              isValid: false}, 

  {id:"a8", piece: "black-rook",    isValid: false},
  {id:"a7", piece: "black-pawn",    isValid: false}, 
  {id:"a6", piece: "",              isValid: false}, 
  {id:"a5", piece: "",              isValid: false},


  // Left Quadrant Red
  {id:"a4", piece: "",              isValid: false},
  {id:"a3", piece: "",              isValid: false}, 
  {id:"a2", piece: "yellow-pawn",   isValid: false},
  {id:"a1", piece: "yellow-rook",   isValid: false},

  {id:"b4", piece: "",              isValid: false},
  {id:"b3", piece: "",              isValid: false}, 
  {id:"b2", piece: "yellow-pawn",   isValid: false},
  {id:"b1", piece: "yellow-knight", isValid: false},

  {id:"c4", piece: "",              isValid: false},
  {id:"c3", piece: "",              isValid: false}, 
  {id:"c2", piece: "yellow-pawn",   isValid: false},
  {id:"c1", piece: "yellow-bishop", isValid: false},

  {id:"d4", piece: "",              isValid: false},
  {id:"d3", piece: "",              isValid: false}, 
  {id:"d2", piece: "yellow-pawn",   isValid: false},
  {id:"d1", piece: "yellow-queen",  isValid: false},


  //Right Quadrant Red
  {id:"e4", piece: "",              isValid: false},
  {id:"e3", piece: "",              isValid: false}, 
  {id:"e2", piece: "yellow-pawn",   isValid: false},
  {id:"e1", piece: "yellow-king",   isValid: false},

  {id:"f4", piece: "",              isValid: false}, 
  {id:"f3", piece: "",              isValid: false},
  {id:"f2", piece: "yellow-pawn",   isValid: false},
  {id:"f1", piece: "yellow-bishop", isValid: false},

  {id:"g4", piece: "",              isValid: false},
  {id:"g3", piece: "",              isValid: false},
  {id:"g2", piece: "yellow-pawn",   isValid: false},
  {id:"g1", piece: "yellow-knight", isValid: false},

  {id:"h4",  piece: "",             isValid: false},
  {id:"h3",  piece: "",             isValid: false},
  {id:"h2",  piece: "yellow-pawn",  isValid: false},
  {id:"h1",  piece: "yellow-rook",  isValid: false}

];

export default defaultChessboardState;

