const distanceTo0 = (num: number) => {
  return ({num, distance: Math.abs(num)});
};

export function closestTo0(numbers: number[]) {
  if (numbers.length === 0) {
    return 'no elements';
  }

  const closest = numbers.map(distanceTo0).reduce((acc, cur) => {
    const closerToZero = cur.distance < acc.distance;
    const sameDistanceButPositiveNumber = cur.distance === acc.distance && cur.num > acc.num;
    if (closerToZero || sameDistanceButPositiveNumber) {
      return cur
    }
    return acc;
  }, {distance: Number.MAX_SAFE_INTEGER, num: Number.MAX_SAFE_INTEGER});
  return closest.num
}

export function closestToZero(words: string[]) {
  const containAllLetters = words.filter(containsSameLettersAsZero);
  if (containAllLetters.length === 0) {
    return 'no closest element'
  }
  if (containAllLetters.length === 1) {
    return containAllLetters[0];
  }

  const agg: { length: number, sameLengthWords: string[] } = {length: Number.POSITIVE_INFINITY, sameLengthWords: []};
  const shortestResult = containAllLetters.map(word => ({word, length: word.length}))
    .reduce((acc, curr) => {
      if (curr.length < acc.length) {
        return {length: curr.length, sameLengthWords: [curr.word]}
      }
      return acc;
    }, agg);

  return shortestResult.sameLengthWords[0]
}

export function containsSameLettersAsZero(word: string) {
  return 'zero'.split('').every(letter => word.includes(letter))
}