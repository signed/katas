export function closestToZero(numbers: number[]) {
  if (numbers.length === 0) {
    return 'no elements';
  }
  return Math.min(...numbers)
}
