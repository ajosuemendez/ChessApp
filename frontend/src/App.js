// import './App.css';

// import Board from "./components/Board";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// Pages
import Home from "./pages/Home";
import NotFoundPage from './pages/NotFoundPage';

export default function App() {
  return(
    <Router>
      {/* <Header /> */}
      <Routes>
        <Route exact path="/" element={<Home/>} />
        <Route path="*" element={<NotFoundPage/>} />
      </Routes>
    </Router>
  );
};
