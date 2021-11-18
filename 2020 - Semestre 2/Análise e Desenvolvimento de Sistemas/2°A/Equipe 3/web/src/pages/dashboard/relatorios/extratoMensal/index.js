import React, { useState } from "react";
import "./../../dashboard.css";
import "./index.css";
import Sidenav from "../../../../components/sidenav/index";
import Header from "../../../../components/header/index";
import api from "./../../../../services/api";
import InputMask from "react-input-mask";

function ExtratoMensal() {
  const [data, setData] = useState("");
  const [extrato, setExtrato] = useState("");

  var inputRules = {
    9: "[0-9]",
    a: "[A-Za-z]",
    "*": "[A-Za-z0-9]",
  };

  async function handleSubmit(e) {
    e.preventDefault();
    let total  = 0
    let d = data.split("/");
    let dataPost = {
      mes: parseInt(d[0]),
      ano: parseInt(d[1]),
    };
    try {
      const res = await api.get("/pagamento/extrato/mensal?mes="+dataPost.mes+"&ano="+dataPost.ano,{
        headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
        }
      });
      console.log(res.data);
      res.data.forEach(pagamento => {
        total +=pagamento.valor
      });
      setExtrato(total);
    } catch (error) {
      alert("Algum erro ocorreu,tente novamente mais tarde.");
      console.log(error);
    }
  }

  return (
    <div className="dashboard">
      <Sidenav />
      <div className="content">
        <Header text="Relatório do extrato mensal" />
        <div className="main">
          <div className="contentRelatorio">
            <section>
              <form onSubmit={handleSubmit}>
                <div>
                  <label>Mês e Ano do extrato:</label>
                  <br />
                  <div style={{ display: "inline" }}>
                    <InputMask
                      type="text"
                      mask="99/9999"
                      formatChars={inputRules}
                      value={data}
                      onChange={(e) => setData(e.target.value)}
                      style={{ width: "80%" }}
                    />
                    <button
                      type="submit"
                      style={{
                        width: "15%",
                        marginTop: "0",
                        padding: "0.2999999999999999rem",
                      }}
                    >
                      Consultar
                    </button>
                  </div>
                </div>
              </form>
            </section>
            <section>
              <center>
                <hr style={{ width: "80%" }}></hr>
              </center>

              <h3>
                <b>Extrato Mensal:</b> {extrato}
              </h3>
            </section>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ExtratoMensal;
