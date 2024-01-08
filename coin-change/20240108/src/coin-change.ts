export function coinChange(change: number, denomination: number[]) {
  const result = [...denomination].reverse().reduce((acc, curr) => {
    const coinCount = Math.floor(acc.remaining / curr)
    return {
      coins: Object.assign(acc.coins, {[curr]: coinCount}),
      remaining: acc.remaining - (coinCount * curr)
    };
  }, {
    coins: {},
    remaining: change
  });

  return result.coins
}
