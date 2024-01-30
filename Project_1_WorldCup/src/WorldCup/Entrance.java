package WorldCup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;


public class Entrance {

	public static void main(String[] args) throws IOException {
		
//		文件判定，文件格式，文件是否存在，球员是否符合要求
		System.out.println("输入文件路径：");
		Scanner scanner = new Scanner(System.in);
		
		String filepathString = scanner.nextLine();
		
		File file = new File(filepathString);
		String fileEndFormatString = file.getName();
		if(!fileEndFormatString.endsWith(".txt")) {
			System.out.println("不是txt文件");
			return;
		}
		
		if(!file.exists() || !file.isFile()) {
			System.out.println("file不存在或格式错误");
			return;
		}
		
		BufferedReader bfReader = new BufferedReader(new FileReader(filepathString));
		
		String infoLineString = bfReader.readLine();
		bfReader.close();
		
		String[] countryTeamStrings  = infoLineString.split(",");
		ArrayList<Team> aTeams = new ArrayList<>();

		for(int i = 0; i< countryTeamStrings.length; i++) {
			
			String[] teamInfo = countryTeamStrings[i].split(" ");
			// 假设球员名字不包含数字
			if(teamInfo[1].matches("[a-zA-Z]+") && teamInfo[2].matches("[a-zA-Z]+")) {
				Player tmpP1Player = new Player();
				Player tmpP2Player = new Player();
				
				// 新建球员及球队对象，存储各球队信息
				tmpP1Player.nameString = teamInfo[1];
				tmpP2Player.nameString = teamInfo[2];
				Team tmpTeam = new Team(teamInfo[0], teamInfo[3], tmpP1Player, tmpP2Player);
				
				aTeams.add(tmpTeam);
			}else {
				System.out.println("球员名字不符合要求");
				return;
			}
			
			

		}
		
//		变量初始化
		char choice;
		char choice2menu;

		int preliminaryFlag = 0;
		int finalFlag = 0;
		Game gameStartGame = new Game();
		Team finalTeam1Team = null;
		Team finalTeam2Team = null;
		Team championTeam = null;
		
//		do-while循环，主菜单页面
		do {
			System.out.println("Menu");
			System.out.println("A 进行初赛");
			System.out.println("B 进行决赛");
			System.out.println("C 展示球队战绩");
			System.out.println("D 展示球员的进球数");
			System.out.println("E 展示世界杯结果");
			System.out.println("F 展示决赛队伍");
			System.out.println("G 关闭并将结果写入文件");	
			
			choice = scanner.next().charAt(0);
			
			
//			选项
			switch (choice){
			case 'a':
			case 'A':
				System.out.println("进行初赛");
				// 开始初赛
				if(preliminaryFlag ==0) {
					gameStartGame.tList = aTeams;
					gameStartGame.playPreliminaryGame();
					preliminaryFlag = 1;
					
					// 根据比赛结果，选出决赛队伍
					TreeSet<Team> tsTeams = new TreeSet<>();
					for(Team uniTeam : gameStartGame.tList) {
						tsTeams.add(uniTeam);
					}
					Iterator<Team> iterator = tsTeams.iterator();
					
					finalTeam1Team = iterator.next();
					finalTeam2Team = iterator.next();
				}else {
					System.out.println("初赛已经完成，不可重复举行");
				}
				// 比赛结束，退回主菜单
				System.out.println("按任意键退回主菜单");
				choice2menu	= scanner.next().charAt(0);
				
				break;
				
			case 'b':
			case 'B':
				if(preliminaryFlag == 0) {
					System.out.println("初赛尚未进行，请先开始初赛");
					break;
				}else if(finalFlag == 0) {
					// 执行决赛
					championTeam = gameStartGame.playFinals(finalTeam1Team, finalTeam2Team);
					finalFlag = 1;
				}else {
					System.out.println("决赛已经完成，不可重复举行");
				}
				
				System.out.println("按任意键退回主菜单");
				choice2menu	= scanner.next().charAt(0);
				break;
				
				
			case 'c':
			case 'C':
				System.out.println("展示球队战绩");

				if(preliminaryFlag == 0) {
					System.out.println("初赛尚未进行，请先开始初赛");
					break;
				}else {
					ArrayList<String> rd2 = new ArrayList<String>();
					
					// 战绩信息拼接
					for(Team unit: gameStartGame.tList) {
						String recording = unit.tmNameString + "-played" + unit.rt.played
								+ "-won" + unit.rt.won
								+ "-lost" + unit.rt.lost
								+ "-drawn" + unit.rt.drawn
								+ "-goals" + unit.rt.goals
								+"-points" + unit.rt.points;
						
						rd2.add(recording);			
					}
					// 球队战绩展示
					for(String unit: rd2) {
						System.out.println(unit);
					}
				}
				
				System.out.println("按任意键退回主菜单");
				choice2menu	= scanner.next().charAt(0);
				break;
				
				
			case 'd':
			case 'D':
				System.out.println("展示球员的进球数");
				
				if(preliminaryFlag == 0) {
					System.out.println("初赛尚未进行，请先开始初赛");
					break;
				}else {
					// 各支球队球员进球数展示
					for(Team unit: gameStartGame.tList) {
						System.out.println(unit.p1Player.nameString  + "-" + unit.tmNameString + "-" +unit.p1Player.goal);
						System.out.println(unit.p2Player.nameString  + "-" + unit.tmNameString + "-" + unit.p2Player.goal);
					}
				}
				
				System.out.println("按任意键退回主菜单");
				choice2menu	= scanner.next().charAt(0);
				break;
				
				
			case 'e':
			case 'E':
				System.out.println("展示世界杯结果");
				// 冠军球队信息，冠军球队进球数最多球员信息判定和展示
				if(championTeam != null) {
					System.out.println("Champion-" + championTeam.tmNameString);
					if(championTeam.p1Player.goal > championTeam.p2Player.goal) {
						System.out.println("MVP-" + championTeam.p1Player.nameString);
					}else if(championTeam.p1Player.goal < championTeam.p2Player.goal) {
						System.out.println("MVP-" + championTeam.p2Player.nameString);
					}else {
						Random rMVPRandom = new Random();
						if(rMVPRandom.nextInt(2) == 0) {
							System.out.println("MVP-" + championTeam.p1Player.nameString);
						}else {
							System.out.println("MVP-" + championTeam.p2Player.nameString);
						}	
					}	
				} else {
					System.out.println("比赛尚未结束");
				}
		
				System.out.println("按任意键退回主菜单");
				choice2menu	= scanner.next().charAt(0);
				break;
				
				
			case 'f':
			case 'F':
				System.out.println("展示决赛队伍");
				if(preliminaryFlag == 0) {
					System.out.println("初赛尚未进行，请先开始初赛");
					break;
				}else {
					System.out.println("决赛队伍为-"+ finalTeam1Team.tmNameString + "-" + finalTeam2Team.tmNameString);
				}
				
				System.out.println("按任意键退回主菜单");
				choice2menu	= scanner.next().charAt(0);
				
				break;
				
				
			case 'g':
			case 'G':
				System.out.println("关闭并将结果写入文件");
				
				String fileNameString = "Result.txt";
				
				FileWriter fWriter = new FileWriter(fileNameString);
				BufferedWriter bfWriter = new BufferedWriter(fWriter);
				
				// E中展示内容写入文件
				if(championTeam != null) {
					bfWriter.write("Champion-" + championTeam.tmNameString);
					bfWriter.newLine();
					if(championTeam.p1Player.goal > championTeam.p2Player.goal) {
						bfWriter.write("MVP-" + championTeam.p1Player.nameString);
					}else if(championTeam.p1Player.goal < championTeam.p2Player.goal) {
						bfWriter.write("MVP-" + championTeam.p2Player.nameString);
					}else {
						Random rMVPRandom = new Random();
						if(rMVPRandom.nextInt(2) == 0) {
							bfWriter.write("MVP-" + championTeam.p1Player.nameString);
						}else {
							bfWriter.write("MVP-" + championTeam.p2Player.nameString);
						}	
					}	
				} else {
					bfWriter.write("比赛尚未结束");
				}
				
				bfWriter.close();
				
				System.out.println("文件写入成功");
				
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			
			}
		}while(choice !='g' && choice != 'G' );
		
		scanner.close();
	}
}


class Player{
	String nameString;
	int goal = 0;
	int penaltyGoal = 0;
}

// Team类依照points建树，初赛后排列，方便选出决赛球队
class Team implements Comparable{
	String tmNameString;
	int ranking;
	Player p1Player;
	Player p2Player;
	Result rt = new Result();
	
	Team(String s1, String s2, Player p1, Player p2){
		this.tmNameString = s1;
		this.ranking = Integer.valueOf(s2).intValue();
		this.p1Player = p1;
		this.p2Player = p2;	
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Team tmTeam = (Team)o;
		return tmTeam.rt.points - this.rt.points;
	}
}


class Result{
	int played = 0;
	int won= 0;
	int lost= 0;
	int drawn= 0;
	int goals= 0;
	int points= 0;
}

class Game{
	ArrayList<Team> tList;
	
	// 设定返回值表示比赛结果，1：平局，2：Team1胜，3：Team2胜
//	两只球队比赛，传入两只队伍，记录比赛结果
	int playGame(Team t1Team, Team t2Team) {
		t1Team.rt.played ++;
		t2Team.rt.played ++;
		Random r1Random = new Random(); // 0-2之间的随机数
		Random r2Random = new Random(); // 进球数二次随机
		
		int goalRange1 = r2Random.nextInt(5 - r1Random.nextInt(3));
		int goalRange2 = r2Random.nextInt(5 + r1Random.nextInt(3));
		
		int t1Teamtemp;
		int t2Teamtemp;
		// 球队胜负根据历史排名，进球数判断依据
		if(t1Team.ranking < t2Team.ranking) {
			t1Teamtemp = goalRange1;
			t2Teamtemp = goalRange2;
		}else {
			t1Teamtemp = goalRange2;
			t2Teamtemp = goalRange1;
		}
		
		// 球队进球数
		t1Team.rt.goals = t1Team.rt.goals + t1Teamtemp;
		t2Team.rt.goals = t2Team.rt.goals + t2Teamtemp;
		
		// 对弈双方，球员进球数，比赛累计
		if(t1Teamtemp % 2 == 0) {
			int t1Player1GoalTmp = t1Teamtemp /2;
			t1Team.p1Player.goal += t1Player1GoalTmp;
			t1Team.p2Player.goal += (t1Teamtemp - t1Player1GoalTmp);
		}else {
			int t1Player1GoalTmp = (t1Teamtemp+1) /2;
			t1Team.p1Player.goal += t1Player1GoalTmp;
			t1Team.p2Player.goal += (t1Teamtemp - t1Player1GoalTmp);
		}
		
		if(t2Teamtemp % 2 == 0) {
			int t2Player1GoalTmp = t2Teamtemp /2;
			t2Team.p1Player.goal += t2Player1GoalTmp;
			t2Team.p2Player.goal += (t2Teamtemp - t2Player1GoalTmp);
		}else {
			int t2Player1GoalTmp = (t2Teamtemp+1) /2;
			t2Team.p1Player.goal += t2Player1GoalTmp;
			t2Team.p2Player.goal += (t2Teamtemp - t2Player1GoalTmp);
		}
		
		
		if(t1Teamtemp == t2Teamtemp) {
			t1Team.rt.points += 1;
			t1Team.rt.drawn ++;
			t2Team.rt.points += 1;
			t2Team.rt.drawn ++;
			return 1;
			
		}else if(t1Teamtemp > t2Teamtemp) {
			t1Team.rt.points += 3;
			t1Team.rt.won ++;
			t2Team.rt.points += 0;
			t2Team.rt.lost++;
			return 2;
		}else {
			t1Team.rt.points += 0;
			t1Team.rt.lost++;
			t2Team.rt.points += 3;
			t2Team.rt.won ++;
			return 3;
		}	
	}
	
	// 初赛进行6场比赛，两两对战
	
	// 进行初赛方法，4支队伍对战，共进行6场比赛
	void playPreliminaryGame() {
		playGame(tList.get(0), tList.get(1));
		playGame(tList.get(0), tList.get(2));
		playGame(tList.get(0), tList.get(3));
		playGame(tList.get(1), tList.get(2));
		playGame(tList.get(1), tList.get(3));
		playGame(tList.get(2), tList.get(3));
	}
	
	
	// 决赛，返回获胜球队信息
	Team playFinals(Team t1, Team t2) {
		int finalResult = playGame(t1, t2);
		if(finalResult ==1) {
			return playPenaltyShootOut(t1, t2);
		}else if(finalResult ==2) {
			return t1;
		}else {
			return t2;
		}
		
	}
	
	// 点球大战，返回获胜球队信息
	Team playPenaltyShootOut(Team t1Team, Team t2Team) {
		
		for(int i = 0; i<5; i ++) {
			t1Team.p1Player.penaltyGoal += penaltyGoal();
			t1Team.p2Player.penaltyGoal += penaltyGoal();
			t2Team.p1Player.penaltyGoal += penaltyGoal();
			t2Team.p2Player.penaltyGoal += penaltyGoal();
		}
		
		int goalRecoder1 = t1Team.p1Player.penaltyGoal + t1Team.p2Player.penaltyGoal;
		int goalRecoder2 = t2Team.p1Player.penaltyGoal + t2Team.p2Player.penaltyGoal;
		t1Team.rt.goals += goalRecoder1;
		t2Team.rt.goals += goalRecoder2;
		
		if(goalRecoder1 > goalRecoder2) {
			t1Team.rt.drawn--;
			t1Team.rt.won++;
			t2Team.rt.drawn--;
			t2Team.rt.lost++;
			return t1Team;
		}else if(goalRecoder1 < goalRecoder2){ 
			t1Team.rt.drawn--;
			t1Team.rt.lost++;
			t2Team.rt.drawn--;
			t2Team.rt.won++;
			return t2Team;
		}else {
			Random random = new Random();
			int chioce = random.nextInt(2);
			if(chioce == 0) {
				t1Team.rt.drawn--;
				t1Team.rt.won++;
				t2Team.rt.drawn--;
				t2Team.rt.lost++;
				return t1Team;
			}else {
				t1Team.rt.drawn--;
				t1Team.rt.lost++;
				t2Team.rt.drawn--;
				t2Team.rt.won++;
				return t2Team;
			}
		}
	}
	
	// 球员点球成功率
	int penaltyGoal() {
		double probabilityOfZero = 0.2;
		double randomNumber = Math.random();
		
		int getGoal;
		if(randomNumber < probabilityOfZero) {
			getGoal = 0;
		}else {
			getGoal =1;
		}
		return getGoal;
	}
}