import { DataTable } from "components/DataTable";
import { Footer } from "components/Footer";
import { Navbar } from "components/Navbar";

function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <h2 className="text-primary">Olá</h2>
        <DataTable /> 
      </div>
      <Footer />
    </>
  );
}

export default App;
