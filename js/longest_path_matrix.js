function findLongestPath(matrix) {
    const paths = [];
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix.length; j++) {
            paths.push(findLongestPathFrom(matrix, i, j, 1));
        }
    }

    return paths.reduce((a, b) => Math.max(a, b));
}

function findLongestPathFrom(matrix, i, j, dist) {
    if (i > 0 && matrix[i - 1][j] - matrix[i][j] === 1) {
        return findLongestPathFrom(matrix, i - 1, j, dist + 1);
    }

    if (j > 0 && matrix[i][j - 1] - matrix[i][j] === 1) {
        return findLongestPathFrom(matrix, i, j - 1, dist + 1);
    }

    if (i < matrix.length - 1 && matrix[i + 1][j] - matrix[i][j] === 1) {
        return findLongestPathFrom(matrix, i + 1, j, dist + 1);
    }
    
    if (j < matrix.length - 1 && matrix[i][j + 1] - matrix[i][j] === 1) {
        return findLongestPathFrom(matrix, i, j + 1, dist + 1);
    }

    return dist;
}

function findLongestPathDP(matrix) {
    const scoreMatrix = [];
    const n = matrix.length;

    for (let i = 0; i < n; i++) {
        const row = [];
        for (let j = 0; j < n; j++) {
            row.push(1);
        }

        scoreMatrix.push(row);
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (scoreMatrix[i][j] !== 1) {
                continue;
            }

            let terminated = false;
            let row = i;
            let column = j;
            while (!terminated) {
                if (row > 0 && matrix[row - 1][column] - matrix[row][column] === 1) {
                    scoreMatrix[row - 1][column] = scoreMatrix[row][column] + 1;
                    row = row - 1;
                } else if (column > 0 && matrix[row][column - 1] - matrix[row][column] === 1) {
                    scoreMatrix[row][column - 1] = scoreMatrix[row][column] + 1;
                    column = column - 1;
                } else if (row < matrix.length - 1 && matrix[row + 1][column] - matrix[row][column] === 1) {
                    scoreMatrix[row + 1][column] = scoreMatrix[row][column] + 1;
                    row = row + 1;
                } else if (column < matrix.length - 1 && matrix[row][column + 1] - matrix[row][column] === 1) {
                    scoreMatrix[row][column + 1] = scoreMatrix[row][column] + 1;
                    column = column + 1;
                } else {
                    terminated = true;
                }
            }
        }
    }

    let max = -1;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (scoreMatrix[i][j] > max) {
                max = scoreMatrix[i][j];
            }
        }
    }

    return max;
}

const matrix = [[1, 2, 9, 16],
                [5, 3, 8, 15],
                [4, 6, 7, 14],
                [10, 11, 12, 13]];

findLongestPathDP(matrix);