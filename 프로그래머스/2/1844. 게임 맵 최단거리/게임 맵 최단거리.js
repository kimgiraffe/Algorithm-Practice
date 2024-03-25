function solution(maps) {
    const dx = [-1, 0, 1, 0];
    const dy = [0, 1, 0, -1];
    
    let queue = [];
    let visited = Array.from(Array(maps.length), () => Array(maps[0].length).fill(false));
    let distance = Array.from(Array(maps.length), () => Array(maps[0].length).fill(0));
    visited[0][0] = true;
    distance[0][0] = 1;
    queue.push([0, 0]);
    
    function bfs(x, y) {
        while(queue.length > 0) {
            let size = queue.length;
            for(let i = 0; i < size; i++) {
                let [x, y] = queue.shift();
                
                for(let dir = 0; dir < 4; dir++) {
                    let nx = x + dx[dir];
                    let ny = y + dy[dir];
                    
                    if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length && maps[nx][ny] === 1 && visited[nx][ny] === false) {
                        if(nx === maps.length - 1 && ny === maps[0].length - 1) {
                            visited[nx][ny] = true;
                            distance[nx][ny] = distance[x][y] + 1;
                            queue.push([nx, ny]);
                            return;
                        }
                        queue.push([nx, ny]);
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }
        
    }
    
    bfs(0, 0);
    
    console.log(distance);
    
    if(visited[maps.length-1][maps[0].length-1] === false) {
        return -1;
    } else {
        return distance[maps.length-1][maps[0].length-1];
    }
    
    
}