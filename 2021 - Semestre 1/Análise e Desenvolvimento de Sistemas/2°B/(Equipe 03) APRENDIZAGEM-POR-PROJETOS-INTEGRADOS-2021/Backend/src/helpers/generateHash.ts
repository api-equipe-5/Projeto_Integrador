const generateHash = (): string => {
  return `${Math.floor(
    Math.random() * Math.floor(9999)
  ).toString()}${Math.random().toString(36).substring(2, 5)}`;
};

export default generateHash;
