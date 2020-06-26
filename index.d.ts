declare module 'tenjin-rn' {
  export interface TenjinRn {
    sendTenjinPurchaseEvent(sku: string, purchaseData: string, dataSignature: string, price: number, currencyCode: string): Promise<boolean>;
  }

  export default TenjinRn;
}
