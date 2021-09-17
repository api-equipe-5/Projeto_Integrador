const sortWorkedHoursDecreasing = (a, b) => {
  if (a.horas > b.horas) {
    return -1;
  }
  if (b.horas < a.horas) {
    return 1;
  }
  return 0;
};

const sortWorkedHoursIncreasing = (a, b) => {
  if (a.horas < b.horas) {
    return -1;
  }
  if (b.horas > a.horas) {
    return 1;
  }
  return 0;
};

export { sortWorkedHoursDecreasing, sortWorkedHoursIncreasing };
