import React, { useState, useEffect } from "react";
import "./../../dashboard.css";
import "./index.css";
import Sidenav from "../../../../components/sidenav/index";
import Header from "../../../../components/header/index";
import api from "./../../../../services/api";

function Descumprimento() {
  const [jornadas, setJornadas] = useState();

  async function getJornadas() {
    try {
      const res = await api.get("/jornada/canceled/", {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      });
      setJornadas(res.data);
    } catch (error) {
      alert("Algum erro ocorreu,tente novamente mais tarde.");
      console.log(error);
    }
  }
  useEffect(() => {
    getJornadas();
  }, []);

  return (
    <div className="dashboard">
      <Sidenav />
      <div className="content">
        <Header text="Relatório de descumprimento da jornada" />
        <div className="main">
          <div className="contentRelatorio">
            <section>
              <center>
                <h3>
                  <b>Jornadas não cumpridas:</b>
                </h3>
              </center>
              <h5>
                <pre>{jornadas}</pre>
              </h5>
            </section>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Descumprimento;
