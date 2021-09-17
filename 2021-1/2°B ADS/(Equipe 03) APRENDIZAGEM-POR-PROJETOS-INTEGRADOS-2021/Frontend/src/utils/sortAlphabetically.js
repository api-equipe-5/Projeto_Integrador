const sortUp = (a, b) => {
  if (a.descricao < b.descricao) {
    return -1;
  }
  if (a.descricao > b.descricao) {
    return 1;
  }
  return 0;
};

const sortDown = (a, b) => {
  if (a.descricao > b.descricao) {
    return -1;
  }
  if (a.descricao < b.descricao) {
    return 1;
  }
  return 0;
};

export { sortUp, sortDown };
