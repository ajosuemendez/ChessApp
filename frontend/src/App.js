import "./styles/App.css"
// import Board from "./components/Board";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// Layout
import Header from './layout/Header';

// Pages
import Home from "./pages/Home";
import Game from "./pages/Game";
import NotFoundPage from './pages/NotFoundPage';

export default function App() {
  return(
    <Router>
      <Header/>
      <Routes>
        <Route exact path="/" element={<Home/>} />
        <Route exact path="/game" element={<Game/>} />
        <Route path="*" element={<NotFoundPage/>} />
      </Routes>
    </Router>
  );
};
