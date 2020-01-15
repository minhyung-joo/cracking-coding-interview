function longestIncreasingSubsequence(arr) {
  if (arr.length === 0) {
    return 0;
  }

  return longestIncreasingSubsequenceRecursive(arr, 0, arr.length, []);
}

function longestIncreasingSubsequenceRecursive(arr, start, end, cur) {
  if (end - start <= 0) {
    return cur.length;
  }

  const subsequences = [];
  for (let i = start; i < end; i++) {
    if (cur.length === 0 || cur[cur.length - 1] < arr[i]) {
      const res = longestIncreasingSubsequenceRecursive(
        arr,
        i + 1,
        end,
        cur.concat(arr[i])
      );
      subsequences.push(res);
    }
  }

  return subsequences.reduce((a, b) => Math.max(a, b));
}

function longestIncreasingSubsequenceDP(arr) {
  if (arr.length < 2) {
    return arr.length;
  }

  const max = new Array(arr.length + 1);
  max[0] = 0;
  max[1] = 1;
  for (let i = 2; i <= arr.length; i++) {
    const possible = [];
    for (let j = i - 1; j > 0; j--) {
      if (arr[j - 1] < arr[i - 1]) {
        possible.push(max[j]);
      }
    }

    if (possible.length) {
      max[i] = 1 + possible.reduce((a, b) => Math.max(a, b));
    } else {
      max[i] = max[i - 1];
    }
  }

  return max[arr.length];
}

console.log(longestIncreasingSubsequenceDP([50, 3, 10, 7, 40, 80]));
