package Sep;

import java.util.*;

public class Solution_PG_3���� {

	boolean[][] visitBoard;
	boolean[][] visitTable;
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	int answer = 0;

	public int solution(int[][] game_board, int[][] table) {
		int boardSize = game_board.length;
		visitBoard = new boolean[boardSize][boardSize];
		visitTable = new boolean[boardSize][boardSize];

		// game_board ���� '�� ����' �� �ϳ� �� ����
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {

				if (game_board[i][j] == 1 || visitBoard[i][j]) { // '�� ����' �ƴϰų� �̹� �湮�� ������ ��� ��ŵ
					continue;
				}

				// �� ���� ������ �����ϸ� bfs�� �ش� ������ ��ǥ�� ã�� Ŭ����(Position) ���� �� ����Ʈ�� ��ȯ
				// ��ǥ ����Ʈ�� ������ 2���� �迭�� �׷��ش� (0,0 ���� �����ϵ���)
				List<Position> emptyCoord = extractBlock(game_board, new Position(i, j), true);
				int[][] empty = makeBlock(emptyCoord);

				// table ���� '��' ���� ����
				match: for (int k = 0; k < boardSize; k++) {
					for (int l = 0; l < boardSize; l++) {

						if (table[k][l] == 0 || visitTable[k][l]) {
							continue;
						}

						// '��' ������ ��ǥ(Position) �� ������ ����Ʈ ��ȯ
						List<Position> blockCoord = extractBlock(table, new Position(k, l), false);

						if (emptyCoord.size() != blockCoord.size()) { // '�� ����' �� '��' �� ��ǥ ������ �ٸ��� ��ŵ
							continue;
						}

						// '��' ��ǥ ����Ʈ�� ������ 2���� �迭�� �׷��ش�
						// 'row', 'col' ���̸� ���� �̾��ִ� ������ '��' ȸ�� �� 2���� �迭�� 0,0 ���� �׸��� ����
						int[][] block = makeBlock(blockCoord);
						int row = blockCoord.get(0).maxX - blockCoord.get(0).minX + 1; // '��' �� �� ����
						int col = blockCoord.get(0).maxY - blockCoord.get(0).minY + 1; // '��' �� �� ����

						// '�� ����' �� '��' ��� Ȯ��
						for (int z = 0; z < 4; z++) {

							if (isSame(empty, block)) { // ����� ������ ��� table ���� �ش翵������ '0'���� ���� �����ش�
								for (int x = 0; x < blockCoord.size(); x++) {
									Position rollback = blockCoord.get(x);
									table[rollback.x][rollback.y] = 0;
								}
								answer += blockCoord.size();
								break match;
							}

							// ��Ī�� �ȵȰ�� ȸ��
							// row, col�� ���̸� �����ϴ� ������ '90'�� ȸ�� �� ��, �� ���̰� �ٲ�� ������ 2���� �迭 0,0 ���� �׸��� ����
							block = rotateBlock(block, row, col);
							int temp = row;
							row = col;
							col = temp;
						}
					}
				}

				visitTable = new boolean[boardSize][boardSize];
			}
		}

		return answer;
	}

	public List<Position> extractBlock(int[][] board, Position p, boolean isBoard) {
		int boardSize = board.length;
		List<Position> list = new ArrayList<>();
		Queue<Position> eq = new LinkedList<>();

		eq.offer(p);

		if (isBoard) {
			visitBoard[p.x][p.y] = true;
		} else {
			visitTable[p.x][p.y] = true;
		}

		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;

		while (!eq.isEmpty()) {
			Position start = eq.poll();
			list.add(start);
			minX = Math.min(start.x, minX);
			minY = Math.min(start.y, minY);
			maxX = Math.max(start.x, maxX);
			maxY = Math.max(start.y, maxY);

			for (int i = 0; i < 4; i++) {
				int row = start.x + dx[i];
				int col = start.y + dy[i];

				if (row < 0 || col < 0 || row > boardSize - 1 || col > boardSize - 1)
					continue;

				if (isBoard) {
					if (board[row][col] == 1 || visitBoard[row][col])
						continue;
					visitBoard[row][col] = true;
				} else {
					if (board[row][col] == 0 || visitTable[row][col])
						continue;
					visitTable[row][col] = true;
				}

				eq.offer(new Position(row, col));
			}
		}

		list.get(0).minX = minX;
		list.get(0).minY = minY;
		list.get(0).maxX = maxX;
		list.get(0).maxY = maxY;

		return list;
	}

	public int[][] makeBlock(List<Position> list) {
		int[][] result = new int[50][50];
		int minX = list.get(0).minX;
		int minY = list.get(0).minY;

		int emptyBlockSize = list.size();
		for (int i = 0; i < emptyBlockSize; i++) {
			Position p = list.get(i);
			result[p.x - minX][p.y - minY] = 1;
		}

		return result;
	}

	public boolean isSame(int[][] empty, int[][] block) {
		for (int i = 0; i < empty.length; i++) {
			for (int j = 0; j < empty[0].length; j++) {
				if (block[i][j] != empty[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][] rotateBlock(int[][] block, int row, int col) { // ȸ��
		int[][] tempBlock = new int[50][50];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				tempBlock[j][row - 1 - i] = block[i][j];
			}
		}
		return tempBlock;
	}

	class Position {
		int x;
		int y;
		int minX;
		int minY;
		int maxX;
		int maxY;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}