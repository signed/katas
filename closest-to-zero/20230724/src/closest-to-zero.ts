const distanceToZero = (num:number) => {
  return ({num, distance: Math.abs(num)});
};

export function closestToZero(numbers: number[]) {
  if (numbers.length === 0) {
    return 'no elements';
  }

  const closest = numbers.map(distanceToZero).reduce((acc, cur) => {
    const closerToZero = cur.distance < acc.distance;
    const sameDistanceButPositiveNumber = cur.distance === acc.distance && cur.num > acc.num;
    if (closerToZero || sameDistanceButPositiveNumber) {
      return cur
    }
    return acc;
  }, {distance: Number.MAX_SAFE_INTEGER, num: Number.MAX_SAFE_INTEGER});
  return closest.num
}
