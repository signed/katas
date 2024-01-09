export function closestToZero(numbers: number[]) {
  if (numbers.length === 0) {
    return 'no elements';
  }
  const weighted = numbers.map((num) => {
    return ({num, distance: Math.abs(num)});
  });
  const closest = weighted.reduce((acc, cur) => {
    if (cur.distance < acc.distance) {
      return cur
    }
    if (cur.distance === acc.distance && cur.num > acc.num) {
      return cur
    }
    return acc;
  }, {distance: Number.MAX_SAFE_INTEGER, num: Number.MAX_SAFE_INTEGER});
  return closest.num
}
