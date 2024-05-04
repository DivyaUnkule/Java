package com.app.core;

public enum ServicePlans {
	
		SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
		
		private double planCost;
		
		private ServicePlans (double planCost)
		{
			this.planCost=planCost;
		}

		public double getPlanCost() {
			return planCost;
		}

		
	}


