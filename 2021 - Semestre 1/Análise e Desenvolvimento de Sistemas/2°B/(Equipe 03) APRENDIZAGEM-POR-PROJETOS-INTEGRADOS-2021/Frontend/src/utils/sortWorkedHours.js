const sortWorkedHours = (a, b) => {
  if (Object.entries(a)[0][1] > Object.entries(b)[0][1]) {
    return -1;
  }
  if (Object.entries(a)[0][1] < Object.entries(b)[0][1]) {
    return 1;
  }
  return 0;
};
export default sortWorkedHours;
