export interface AudioFocusPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
