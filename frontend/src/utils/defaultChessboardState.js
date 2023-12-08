// utils/initialPositionState.js
// const settings = {
//   themes: {classical: {startSquare: white, endSquare: black, playerOne: themeChessNuts}}
// }

const defaultChessboardState = [
  // Left Quadrant White 
  {id:"H12", piece: "white-rook",   color: "#D9D9D9", centerPos: {x:952, y:1215}, shape: "M996.01 1190.42L1025.79 1273.74L947.923 1273.24L909.491 1205.59L996.01 1190.42Z" },
  {id:"H11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:920, y:1140}, shape: "M967.829 1110.48L995.603 1189.27L908.862 1204.49L872.881 1141.15L967.829 1110.48Z" },
  {id:"H10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M837.03 1078.05L939.71 1031.65L967.428 1109.35L872.316 1140.16L837.03 1078.05Z" },
  {id:"H9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M911.525 951.702L939.307 1030.52L836.247 1077.23L800.322 1015.22L911.525 951.702Z" },

  {id:"G12", piece: "white-knight", color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1080.25 1175.88L1099.83 1274.3L1027.07 1273.75L997.21 1190.21L1080.25 1175.88Z" },
  {id:"G11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1061.09 1080.48L1080.01 1174.71L996.802 1189.06L968.971 1110.11L1061.09 1080.48Z" },
  {id:"G10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1042.18 985.498L1060.86 1079.29L968.57 1108.98L940.807 1031.16L1042.18 985.498Z" },
  {id:"G9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1022.72 888.528L1041.94 984.29L940.405 1030.02L912.585 951.098L1022.72 888.528Z" },

  {id:"F12", piece: "white-bishop", color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1163.38 1161.41L1172.72 1274.91L1101.06 1274.31L1081.43 1175.68L1163.38 1161.41Z" },
  {id:"F11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1153.69 1050.29L1163.28 1160.21L1081.2 1174.5L1062.24 1080.1L1153.69 1050.29Z" },
  {id:"F10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1143.8 939.833L1153.58 1049.06L1062.01 1078.92L1043.31 984.992L1143.8 939.833Z" },
  {id:"F9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1133.92 825.353L1143.69 938.568L1043.06 983.785L1023.82 887.904L1133.92 825.353Z" },

  {id:"E12", piece: "white-queen",  color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1246.09 1147.17L1245.58 1275.53L1173.93 1274.92L1164.57 1161.2L1246.09 1147.17Z" },
  {id:"E11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1247.39 1020.03L1246.1 1145.95L1164.47 1160L1154.86 1049.9L1247.39 1020.03Z" },
  {id:"E10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1248.7 892.876L1247.41 1018.76L1154.75 1048.68L1144.96 939.313L1248.7 892.876Z" },
  {id:"E9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1248.4 761.024L1248.71 891.557L1144.84 938.051L1134.2 825.195L1248.4 761.024Z" },

  
  // Right Quadrant White 
  {id:"I12", piece: "white-king",   color: "#A23131", centerPos: {x:300, y:300}, shape: "M1246.6 1147.22L1328.85 1161.99L1318.45 1275.4H1246.6V1147.22Z" },
  {id:"I11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1246.6 1019.33L1339.36 1049.92L1328.96 1160.79L1246.6 1146V1019.33Z" },
  {id:"I10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1246.6 891.436L1349.86 938.868L1339.47 1048.69L1246.6 1018.07V891.436Z" },
  {id:"I9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1249.58 761.018L1360.87 824.329L1349.98 937.61L1246.61 891.116L1249.58 761.018Z" },

  {id:"J12", piece: "white-bishop", color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1319.66 1275.4L1330.04 1162.2L1411.29 1176.48L1391.51 1275.4H1319.66Z" },
  {id:"J11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1340.53 1050.31L1431.3 1080.4L1411.53 1175.31L1330.15 1161L1340.53 1050.31Z" },
  {id:"J10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1351.02 939.395L1450.82 984.848L1431.55 1079.22L1340.64 1049.08L1351.02 939.395Z" },
  {id:"J9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1362.01 824.99L1470.82 888.301L1451.06 983.643L1351.14 938.131L1362.01 824.99Z" },

  {id:"K12", piece: "white-knight", color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1412.47 1176.69L1494.7 1191.47L1465.57 1275.4H1392.73L1412.47 1176.69Z" },
  {id:"K11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1432.45 1080.78L1523.73 1110.88L1495.11 1190.32L1412.71 1175.52L1432.45 1080.78Z" },
  {id:"K10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1451.94 985.36L1552.25 1031.32L1524.13 1109.75L1432.69 1079.6L1451.94 985.36Z" },
  {id:"K9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1471.92 888.938L1580.77 952.267L1552.66 1030.18L1452.18 984.154L1471.92 888.938Z" },

  {id:"L12", piece: "white-rook",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1495.9 1191.68L1583.06 1206.94L1544.65 1275.4H1466.84L1495.9 1191.68Z" },
  {id:"L11", piece: "white-pawn",   color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1524.87 1111.25L1620.11 1142.84L1583.69 1205.84L1496.31 1190.53L1524.87 1111.25Z" },
  {id:"L10", piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1553.34 1031.82L1656.65 1079.77L1620.73 1141.78L1525.27 1110.12L1553.34 1031.82Z" },
  {id:"L9",  piece: null,           color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1581.82 952.876L1693.18 1016.72L1657.26 1078.73L1553.75 1030.69L1581.82 952.876Z" },
  

  // Left Quadrant Black
  {id:"L8", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1745.96 758.538L1802.84 690.761L1841.72 758.225L1802.74 825.555L1745.96 758.538Z" },
  {id:"L7", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1691.19 823.226L1745.17 759.468L1802.1 826.657L1765.6 889.693L1691.19 823.226Z" },
  {id:"L6", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1729.24 952.503L1637.34 887.302L1690.41 824.144L1765.03 890.685L1729.24 952.503Z" },
  {id:"L5", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1582.42 951.838L1636.6 887.809L1728.99 953.649L1693.78 1015.68L1582.42 951.838Z" },

  {id:"K8", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1690.87 693.167L1765.93 626.567L1802.2 689.654L1745.17 757.608L1690.87 693.167Z" },
  {id:"K7", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1618.19 757.875L1689.98 693.964L1744.39 758.539L1690.29 822.426L1618.19 757.875Z" },
  {id:"K6", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1545.76 822.156L1617.29 758.677L1689.52 823.344L1636.36 886.605L1545.76 822.156Z" },
  {id:"K5", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1471.89 887.918L1544.84 822.973L1635.58 887.525L1581.51 951.389L1471.89 887.918Z" },

  {id:"J8", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1636.4 628.721L1729.66 563.343L1765.32 625.505L1690.1 692.25L1636.4 628.721Z" },
  {id:"J7", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1545.38 693.198L1635.42 629.415L1689.2 693.047L1617.29 757.071L1545.38 693.198Z" },
  {id:"J6", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1455.03 757.502L1544.38 693.911L1616.39 757.873L1544.76 821.442L1455.03 757.502Z" },
  {id:"J5", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1361.21 823.834L1454 758.237L1543.84 822.26L1470.8 887.286L1361.21 823.834Z" },

  {id:"I8",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1582.35 564.518L1693.4 500.141L1729.06 562.298L1635.62 627.8L1582.35 564.518Z" },
  {id:"I7",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1471.95 627.591L1581.3 565.127L1634.64 628.494L1544.46 692.379L1471.95 627.591Z" },
  {id:"I6",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1361.53 690.665L1470.85 628.219L1543.46 693.092L1454 756.765L1361.53 690.665Z" },
  {id:"I5",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1250.17 759.979L1360.4 691.33L1452.97 757.503L1360.93 823.673L1250.17 759.979Z" },


  // Right Quadrant Black
  {id:"D8", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1581.35 563.607L1556.74 483.947L1660.11 436.13L1694.69 498.773L1581.35 563.607Z" },
  {id:"D7", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1474.42 627.055L1454.5 530.987L1555.64 484.454L1580.29 564.225L1474.42 627.055Z" },
  {id:"D6", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1363.02 691.014L1353.12 577.529L1453.39 531.5L1473.82 627.696L1363.02 691.014Z" },
  {id:"D5", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1249.59 758.946L1248.49 625.382L1351.97 578.059L1361.87 691.678L1249.59 758.946Z" },

  {id:"C8", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1659.52 435.082L1556.35 482.804L1528.01 405.328L1623.53 372.898L1659.52 435.082Z" },
  {id:"C7", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1454.25 529.781L1434.82 436.141L1526.87 405.709L1555.26 483.309L1454.25 529.781Z" },
  {id:"C6", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1353.01 576.263L1342.35 467.12L1433.68 436.522L1453.13 530.296L1353.01 576.263Z" },
  {id:"C5", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1248.48 624.063L1248.77 498.169L1341.18 467.509L1351.85 576.792L1248.48 624.063Z" },

  {id:"B8", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1527.6 404.2L1499.19 325.632L1586.42 308.796L1622.91 371.838L1527.6 404.2Z" },
  {id:"B7", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1434.58 434.958L1414.9 340.884L1497.99 325.856L1526.46 404.581L1434.58 434.958Z" },
  {id:"B6", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1342.23 465.894L1331.75 356.054L1413.72 341.099L1433.43 435.339L1342.23 465.894Z" },
  {id:"B5", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1248.77 496.903L1249.05 370.974L1330.57 356.269L1341.06 466.284L1248.77 496.903Z" },

  {id:"A8", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1498.77 324.49L1468.32 241.405L1546.81 240.358L1585.79 307.697L1498.77 324.49Z" },
  {id:"A7", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1414.65 339.709L1394.28 241.454L1467.05 241.416L1497.58 324.712L1414.65 339.709Z" },
  {id:"A6", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1331.64 354.855L1321.39 241.425L1393.05 241.454L1413.47 339.923L1331.64 354.855Z" },
  {id:"A5", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1249.05 369.755L1248.52 241.395L1320.18 241.424L1330.46 355.07L1249.05 369.755Z" },


  // Left Quadrant Red
  {id:"A4", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1247.85 369.754L1165.3 354.94L1175.99 241.994L1247.32 241.4L1247.85 369.754Z" },
  {id:"A3", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1174.88 242.359L1164.49 354.554L1083.24 340.262L1103.45 242.349L1174.88 242.359Z" },
  {id:"A2", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1082.06 340.051L999.831 325.268L1029.46 242.338L1102.3 242.348L1082.06 340.051Z" },
  {id:"A1", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M998.633 325.055L911.478 309.778L950.386 242.327L1028.19 242.338L998.633 325.055Z" },

  {id:"B4", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1247.9 497.439L1155.15 466.836L1165.56 355.963L1247.92 370.771L1247.9 497.439Z" },
  {id:"B3", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1153.98 466.449L1063.21 436.341L1082.99 341.437L1164.37 355.752L1153.98 466.449Z" },
  {id:"B2", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1062.06 435.962L970.79 405.853L999.42 326.414L1081.81 341.227L1062.06 435.962Z" },
  {id:"B1", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M969.65 405.476L874.409 373.878L910.84 310.884L998.221 326.201L969.65 405.476Z" },

  {id:"C4", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1247.88 625.333L1144.63 577.887L1155.03 468.061L1247.9 498.703L1247.88 625.333Z" },
  {id:"C3", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1143.47 577.359L1043.68 531.892L1062.96 437.525L1153.86 467.675L1143.47 577.359Z" },
  {id:"C2", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1042.56 531.379L942.255 485.409L970.383 406.982L1061.82 437.145L1042.56 531.379Z" },
  {id:"C1", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M941.162 484.904L837.86 436.943L873.795 374.939L969.244 406.605L941.162 484.904Z" },

  {id:"D4", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1248.53 758.951L1133.14 691.676L1144.51 578.89L1247.4 625.389L1248.53 758.951Z" },
  {id:"D3", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1132.47 691.763L1023.66 628.436L1043.43 533.097L1143.35 578.623L1132.47 691.763Z" },
  {id:"D2", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1022.57 627.799L913.728 564.454L941.848 486.542L1042.31 532.586L1022.57 627.799Z" },
  {id:"D1", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M912.672 563.845L801.324 499.984L837.256 437.985L940.754 486.038L912.672 563.845Z" },

  //Right Quadrant Red
  {id:"E4", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1247.8 759.989L1133.67 824.808L1041.38 758.213L1133.72 692.458L1247.8 759.989Z" },
  {id:"E3", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1133.44 692.293L1040.36 757.474L950.807 693.051L1024.14 628.352L1133.44 692.293Z" },
  {id:"E2", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1023.05 627.714L949.808 692.333L859.355 627.376L913.715 563.755L1023.05 627.714Z" },
  {id:"E1", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M912.662 563.139L858.377 626.674L766.603 560.94L802.884 498.92L912.662 563.139Z" },

  {id:"F4", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1132.52 825.459L1022.93 887.416L950.611 822.219L1040.35 758.947L1132.52 825.459Z" },
  {id:"F3", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1039.32 758.205L949.696 821.396L877.97 757.113L949.884 693.865L1039.32 758.205Z" },
  {id:"F2", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M948.884 693.147L877.071 756.305L805.135 691.316L858.575 628.293L948.884 693.147Z" },
  {id:"F1", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M765.994 561.98L857.596 627.591L804.244 690.512L729.925 623.638L765.994 561.98Z" },

  {id:"G4", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M1021.83 888.039L912.202 950.014L859.142 886.409L949.604 822.928L1021.83 888.039Z" },
  {id:"G3", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M948.688 822.105L858.369 885.485L804.868 821.613L877.063 757.912L948.688 822.105Z" },
  {id:"G2", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M876.165 757.103L804.098 820.692L749.977 755.875L804.357 692.23L876.165 757.103Z" },
  {id:"G1", piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M803.466 691.426L749.196 754.943L692.567 687.5L729.346 624.627L803.466 691.426Z" },

  {id:"H4",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M911.143 950.618L799.807 1014.5L764.426 952.183L858.154 887.099L911.143 950.618Z" },
  {id:"H3",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M857.381 886.174L763.831 951.135L728.448 888.815L803.968 822.406L857.381 886.174Z" },
  {id:"H2",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M803.197 821.486L727.843 887.749L691.855 824.501L749.189 756.803L803.197 821.486Z" },
  {id:"H1",  piece: null, color: "#D9D9D9", centerPos: {x:300, y:300}, shape: "M748.407 755.869L691.222 823.392L652.638 755.755L691.923 688.599L748.407 755.869Z" },

];

export default defaultChessboardState;

