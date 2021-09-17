import express from "express";
import routes from "./routes";
import cors from "cors";

const app = express();

app.use((req, res, next) => {
  next();
}, cors());
app.use(express.json());
app.use("/api", routes);

export default app;
