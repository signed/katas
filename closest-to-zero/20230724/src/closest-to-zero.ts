const distanceTo0 = (num:number) => {
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

export function closestToZero(_strings: string[]) {
  return 'no closest element'
}

export function distanceToZero(_s: string) {
  if (_s === 'zero') {
    return 0
  }
  return Number.POSITIVE_INFINITY;
}