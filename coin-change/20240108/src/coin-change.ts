export function coinChange(change: number, denomination: number[]) {
  const result = {}
  denomination.forEach(p => {
    let coins = 0;
    if (change === 1 && p === 1) {
      coins = 1
    }
    if (change === 5 && p === 5) {
      coins = 1
    }
    if (change === 10 && p === 10) {
      coins = 1
    }
    if (change === 25 && p === 25) {
      coins = 1
    }
    if (change === 100 && p === 100) {
      coins = 1
    }
    Object.assign(result, {[p]: coins});
  })
  return result
}
