import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

public class Solver {
	private String filename;
	private ArrayList<String> columns = new ArrayList<String>();
	private String[] data;
	private ArrayList<DataObj> dataObjArray = new ArrayList<DataObj>();

	/*
	 * This constructor creates an Arraylist with DataObjs representing each line of
	 * the csv file It skips over the first line of the csv as that is a header
	 */
	public Solver(String filename) {
		this.filename = filename;

		File input = new File(filename);
		try {
			Scanner s = new Scanner(input);

			while (s.hasNextLine()) {

				// read in column headers
				if (columns.size() == 0) {

					String header = s.nextLine();

					for (String str : header.split(",")) {
						columns.add(str);
					}

				} else {

					// read in rest of the data;
					data = new String[22];

					String row = s.nextLine();

					String[] rowArray = row.split(",");

					for (int i = 0; i < data.length; i++) {
						data[i] = rowArray[i];
					}

					DataObj da = new DataObj(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],
							data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16],
							data[17], data[18], data[19], data[20], data[21]);

					dataObjArray.add(da);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String cancelledAirlineAnswer() {
		/*
		 * Which carrier has the highest percentage of cancelled flights? Output the
		 * 2-letter Carrier ID and the chance of a cancelled flight, as a percentage
		 * (Example: AA,1.22%). This percentage is defined as the number of canceled
		 * flights over the total number of flights.
		 */

		// need to create a key:value for each unique carrier id and cancelled flight.
		// Can state cancelled flight = 1,
		// and no cancelled flight = 0;

		// create an array with k,v of airline id and cancelled data
		ArrayList<CancelledFlightKVPair> cancelledArray = new ArrayList<CancelledFlightKVPair>();

		for (int i = 0; i < dataObjArray.size(); i++) {
			CancelledFlightKVPair kvTemp = new CancelledFlightKVPair(dataObjArray.get(i).getUniqueCarrier(),
					Integer.valueOf(dataObjArray.get(i).getCancelled()));
			cancelledArray.add(kvTemp);
		}

		// putting uniqueCarrier names here
		String[] uniqueCarriers = { "AA", "AS", "B6", "DL", "EV", "F9", "HA", "NK", "OO", "UA", "VX", "WN" };

		// counting number of cancelled flights per airline

		int counterAA = 0;
		int counterAS = 0;
		int counterB6 = 0;
		int counterDL = 0;
		int counterEV = 0;
		int counterF9 = 0;
		int counterHA = 0;
		int counterNK = 0;
		int counterOO = 0;
		int counterUA = 0;
		int counterVX = 0;
		int counterWN = 0;
		

		for (int i = 0; i < cancelledArray.size(); i++)
			if (cancelledArray.get(i).getUniqueCarrier().equals("AA")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterAA = counterAA + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("AS")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterAS = counterAS + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("B6")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterB6 = counterB6 + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("DL")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterDL = counterDL + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("EV")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterEV = counterEV + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("F9")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterF9 = counterF9 + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("HA")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterHA = counterHA + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("NK")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterNK = counterNK + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("OO")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterOO = counterOO + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("UA")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterUA = counterUA + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("VX")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterVX = counterVX + 1;
				}
			} else if (cancelledArray.get(i).getUniqueCarrier().equals("WN")) {
				if (cancelledArray.get(i).getCancelled() == 1) {
					counterWN = counterWN + 1;
				}
			}
		
		//not doing this right. I need the number of flights per operator!
		
		int counterAAflight = 0;
		int counterASflight = 0;
		int counterB6flight = 0;
		int counterDLflight = 0;
		int counterEVflight = 0;
		int counterF9flight = 0;
		int counterHAflight = 0;
		int counterNKflight = 0;
		int counterOOflight = 0;
		int counterUAflight = 0;
		int counterVXflight = 0;
		int counterWNflight = 0;
		
		for (int i = 0; i < cancelledArray.size(); i++)
			if (cancelledArray.get(i).getUniqueCarrier().equals("AA")) {
				counterAAflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("AS")) {
				counterASflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("B6")) {
				counterB6flight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("DL")) {
				counterDLflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("EV")) {
				counterEVflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("F9")) {
				counterF9flight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("HA")) {
				counterHAflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("NK")) {
				counterNKflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("OO")) {
				counterOOflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("UA")) {
				counterUAflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("VX")) {
				counterVXflight++;
			}
			else if (cancelledArray.get(i).getUniqueCarrier().equals("WN")) {
				counterWNflight++;
			}
	
		double counterAAper = Double.valueOf(counterAA) / counterAAflight;
		/*
		double counterASper = Double.valueOf(counterAS) / counterASflight;
		double counterB6per = Double.valueOf(counterB6) / counterB6flight;
		double counterDLper = Double.valueOf(counterDL) / counterDLflight;
		double counterEVper = Double.valueOf(counterEV) / counterEVflight;
		double counterF9per = Double.valueOf(counterF9) / counterF9flight;
		double counterHAper = Double.valueOf(counterHA) / counterHAflight;
		double counterNKper = Double.valueOf(counterNK) / counterNKflight;
		double counterOOper = Double.valueOf(counterOO) / counterOOflight;
		double counterUAper = Double.valueOf(counterUA) / counterUAflight;
		double counterVXper = Double.valueOf(counterVX) / counterVXflight;
		*/
		double counterWNper = Double.valueOf(counterWN) / counterWNflight;
		

		// Realizing this is not a DRY way to do this. Should have figured out how to
		// add the percentages to a list so
		// I could iterate over them

		// String[] uniqueCarriers = {"AA", "AS", "B6", "DL", "EV", "F9", "HA", "NK",
		// "OO", "UA", "VX", "WN"};

		// creating a hashmap with the keys, values
		HashMap<String, Double> hm = new HashMap<String, Double>();
		hm.put("AA", counterAAper);
		/*
		hm.put("AS", counterASper);
		hm.put("B6", counterB6per);
		hm.put("DL", counterDLper);
		hm.put("EV", counterEVper);
		hm.put("F9", counterF9per);
		hm.put("HA", counterHAper);
		hm.put("NK", counterNKper);
		hm.put("OO", counterOOper);
		hm.put("UA", counterUAper);
		hm.put("VX", counterVXper);
		*/
		hm.put("WN", counterWNper);

		
		
		//double highValue = 0.00;
		/*
		for (Double value : hm.values()) {
			if (value > highValue) {
				highValue = value;
			}

		}
		*/
		
		
		
		Double highValue = Collections.max(hm.values());
		
		String highestKey = "";
		for (Entry<String, Double> entry : hm.entrySet()) {
			if(entry.getValue() == highValue) {
				highestKey = entry.getKey();
			}
		}
		
		//System.out.println(highestKey);
		//System.out.println(toPercentage(highValue, 2));
		//System.out.println(hm);

		String finalString = ("(" + highestKey + ", " + toPercentage(highValue,2) + ")");

		return finalString;
	}
	
	//helper to convert double into percentage
	public String toPercentage(double n, int digits){
	    return String.format("%."+digits+"f",n*100)+"%";
	}

	public String questionTwoAnswer() {

		ArrayList<QTwoKV> q2 = new ArrayList<QTwoKV>();

		for (DataObj obj : dataObjArray) {
			if (!obj.getCancellationCode().equals("")) {
				QTwoKV temp = new QTwoKV(obj.getUniqueCarrier(), obj.getCancellationCode());
				q2.add(temp);
			}
		}

		String[] codes = { "A", "B", "C", "D" };

		int counterA = 0;
		int counterB = 0;
		int counterC = 0;
		int counterD = 0;

		for (QTwoKV k : q2) {
			if (k.getCancellationCode().equals("A")) {
				counterA++;
			} else if (k.getCancellationCode().equals("B")) {
				counterB++;
			} else if (k.getCancellationCode().equals("C")) {
				counterC++;
			} else if (k.getCancellationCode().equals("D")) {
				counterD++;
			}
		}

		String maxCancelCode = "";
		
		if (counterA > counterB && counterA > counterC && counterA > counterD) {
			maxCancelCode = "A";
		} else if (counterB > counterA && counterB > counterC && counterB > counterD) {
			maxCancelCode = "B";
		} else if (counterC > counterA && counterC > counterB && counterC > counterD) {
			maxCancelCode = "C";
		} else if (counterD > counterA && counterD > counterC && counterD > counterC) {
			maxCancelCode = "D";
		}

		return maxCancelCode;
	}

	public String questionThreeAnswer() {

		// create a hashmap with all the miles added up
		HashMap<String, Integer> hm3 = new HashMap<String, Integer>();
		
		/*
		for (DataObj obj : dataObjArray) {
			String tailnum = obj.getTailNum();
			int distance = hm3.containsKey(tailnum) ? hm3.get(tailnum) : 0;
			distance += Integer.valueOf(obj.getDistance());
			
			hm3.put(tailnum, distance);
		}
		
		*/
		
		for (DataObj obj : dataObjArray) {
			String tailnum = obj.getTailNum();
			int distance = 0;
			
			if (hm3.containsKey(tailnum)) {
				distance = hm3.get(tailnum);
			} else {
				distance = 0;
			}
			
			distance += Integer.valueOf(obj.getDistance());
			
			hm3.put(tailnum, distance);
		}
		
		
		String tailNumberMax = returnMaxKey(hm3);
		
		
		return tailNumberMax;
	}

	public String questionFourAnswer() {
		//Which airport is the busiest by total number of flights in and out?
		//return OriginAirportID
		
		HashMap<String, Integer> hm4 = new HashMap<String, Integer>();
		
		
		for (DataObj obj : dataObjArray) {
			String airportID = obj.getOriginAirportID();
			int flightCount = 0;
			
			if(hm4.containsKey(airportID)) {
				flightCount = hm4.get(airportID);
			}
			else {
				flightCount = 0;
			}
			
			flightCount += 1;
			hm4.put(airportID, flightCount);
		}
		
		String airportMax = returnMaxKey(hm4);
		
		
		return airportMax;
	}
	
	public String returnMaxKey(HashMap<String, Integer> hm) {
		String keyMax = "";
		int maxValue = Collections.max(hm.values());
		
		for (Entry<String, Integer> entry : hm.entrySet()) { 
            if (entry.getValue() == maxValue) {
                keyMax = entry.getKey();
            }
		}
		
		return keyMax;
	}
	
	public String questionFiveAnswer() {
		
		HashMap<String, Integer> hmdep5 = depFlights();
		HashMap<String, Integer> hmarr5 = arriveFlights();
		
		//creating a delta hashmap
		HashMap<String, Integer> sourceHM = new HashMap<String, Integer>();
		
		for (String key : hmdep5.keySet()) {
			if(hmarr5.containsKey(key)) {
			int delta = hmdep5.get(key) - hmarr5.get(key);
			sourceHM.put(key, delta);
			}
		}
		
		String biggestSource = returnMaxKey(sourceHM);
		
		
		return biggestSource;
	}
	
	public String questionSixAnswer() {
		
		HashMap<String, Integer> hmdep6 = depFlights();
		HashMap<String, Integer> hmarr6 = arriveFlights();
		
		//creating a delta hashmap
		HashMap<String, Integer> sinkHM = new HashMap<String, Integer>();
		
		for (String key : hmarr6.keySet()) {
			if(hmdep6.containsKey(key)) {
			int delta = hmarr6.get(key) - hmdep6.get(key);
			sinkHM.put(key, delta);
			}
		}
		
		String biggestSink = returnMaxKey(sinkHM);
		
		
		return biggestSink;
	}
	
	//Hashmap for departing flights not including cancelled flights
	public HashMap<String, Integer> depFlights(){
		HashMap<String, Integer> hmdep = new HashMap<String, Integer>();
		
		//Start by creating an arraylist without cancelled flights
		
		ArrayList<DataObj> alNoCancelled = new ArrayList<DataObj>();
		
		for (DataObj obj : dataObjArray) {
			if(obj.getCancelled().equals("0")) {
				alNoCancelled.add(obj);
			}
		}
		
		for (DataObj obj : alNoCancelled) {
			String airportID = obj.getOriginAirportID();
			int depFlightCount = 0;
			
			if(hmdep.containsKey(airportID)) {
				depFlightCount = hmdep.get(airportID);
			}
			else {
				depFlightCount = 0;
			}
			
			depFlightCount += 1;
			hmdep.put(airportID, depFlightCount);
		}
		
		
		return hmdep;
	}
	
	
	public HashMap<String, Integer> arriveFlights(){
		HashMap<String, Integer> hmarr = new HashMap<String, Integer>();
		
		//Start by creating an arraylist without cancelled flights
		
		ArrayList<DataObj> alNoCancelled = new ArrayList<DataObj>();
		
		for (DataObj obj : dataObjArray) {
			if(obj.getCancelled().equals("0")) {
				alNoCancelled.add(obj);
			}
		}
		
		for (DataObj obj : alNoCancelled) {
			String airportID = obj.getDestAirportID();
			int arrFlightCount = 0;
			
			if(hmarr.containsKey(airportID)) {
				arrFlightCount = hmarr.get(airportID);
			}
			else {
				arrFlightCount = 0;
			}
			
			arrFlightCount += 1;
			hmarr.put(airportID, arrFlightCount);
		}
		
		
		return hmarr;
	}
	
	public String questionSevenAnswer() {
		//If arrivaldelay or departure delay > 60 (positive value), then add to count
		
		return "hi";
	}
	
	public static void main(String[] args) {
		Solver s = new Solver("flights_small.csv");

		//System.out.println(s.questionThreeAnswer());
		//System.out.println(s.cancelledAirlineAnswer());
		//System.out.println(s.questionFourAnswer());
		//System.out.println(s.questionThreeAnswer());
		System.out.println(s.questionSixAnswer());
		

	}
}
